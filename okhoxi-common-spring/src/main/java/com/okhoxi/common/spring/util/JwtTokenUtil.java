package com.okhoxi.common.spring.util;

import com.google.common.collect.Maps;
import com.okhoxi.common.core.constant.CommonExceptionStatus;
import com.okhoxi.common.core.util.SaftopDate;
import com.okhoxi.common.spring.constant.TokenType;
import com.okhoxi.common.core.exception.BaseException;
import com.okhoxi.common.spring.model.vo.UserTokenVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -3301605591108950415L;
    // user name
    public static final String CLAIM_KEY_USERNAME = "sub";
    public static final String CLAIM_KEY_CREATED = "created";
    // user id
    public static final String CLAIM_KEY_UID = "uid";
    public static final String CLAIM_KEY_NAME = "name";
    public static final String CLAIM_KEY_IP = "ip";
    // tenant id
    public static final String CLAIM_KEY_TID = "tid";
    // token id
    public static final String CLAIM_KEY_ID = "id";
    public static final String CLAIM_KEY_USERTYPE = "utype";
    public static final String CLAIM_KEY_OAUTHTYPE = "oauthType";

    @Value("${gate.jwt.secret:UNKNOWN}")
    private String secret;

    @Value("${gate.jwt.expiration:7200}")
    private Long expiration;
    /**
     * 延长 30分钟
     */
    private static final long EXTEND_TIME = 60*60;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public String getTenantIdFromToken(String token) {
        String tenantId;
        try {
            final Claims claims = getClaimsFromToken(token);
            tenantId = claims.get("tid").toString();
        } catch (Exception e) {
            tenantId = null;
        }
        return tenantId;
    }

    public String getValueFromToken(String token, String key) {
        String Value;
        try {
            final Claims claims = getClaimsFromToken(token);
            Value = (String) claims.get(key);
        } catch (Exception e) {
            Value = null;
        }
        return Value;
    }

    private Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    private Date getExpirationDateFromToken(String token) {
        try {
            final Claims claims = getClaimsFromToken(token);
            return claims.getExpiration();
        } catch (Exception e) {
            log.error("获取token过期时间异常", e);
            throw new BaseException(CommonExceptionStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 根据username 使token过期，在修改用户密码时使用
     * @param username
     * @return
     */
    public boolean expirationTokenByUsername(String username){
        Set<String> keys = redisTemplate.keys("*"+username+"*");
        if(CollectionUtils.isNotEmpty(keys)){
            for (String key : keys) {
                String token = (String)redisTemplate.opsForValue().get(key);
                String tokenID = this.getValueFromToken(token, CLAIM_KEY_ID);
                if(StringUtils.contains(key, username + ":" + tokenID)){
                    redisTemplate.delete(key);
                }
            }
        }
        return true;
    }

    public Boolean invalid(String token, TokenType tokenType) {
        String username = this.getUsernameFromToken(token);
        String tokenID = this.getValueFromToken(token, CLAIM_KEY_ID);

        List<String> keys = new ArrayList<>();
        // 删除用户token记录
        String key = getKey(IPUtil.getIp(), username, tokenID, tokenType);
        keys.add(key);
        // 删除用户权限数据
        keys.add("st:" + username + ":permission");
        redisTemplate.delete(keys);

        return true;
    }

    public Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encodeToString(secret.getBytes()))
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate() {
        return generateExpirationDate(null);
    }

    private Date generateExpirationDate(Long extendTime) {
        long current = System.currentTimeMillis();
        if(extendTime != null){
            current += (extendTime * 1000);
        }else {
            current += (expiration * 1000);
        }
        return new Date(current);
    }

    public Boolean isTokenExpired(String token) {
        final Date expirationDate = getExpirationDateFromToken(token);
        return expirationDate.before(new Date());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public String generateToken(String tenantId, String username, String id, String type, String ip, TokenType tokenType, String name, Long extendTime) {
        if (StringUtils.isEmpty(id)) {
            throw new BaseException(CommonExceptionStatus.MEDIA_TYPE_EX);
        }
        long t1 = System.currentTimeMillis();
        HttpRequestHeadUtil.setCurTenantId(tenantId);
        String strTokenID = UUID.randomUUID().toString().replace("-", "");
        String strKey = getKey(ip, username, strTokenID, tokenType);
        Map<String, Object> claims = Maps.newHashMap();
        claims.put(CLAIM_KEY_USERNAME, username);
        claims.put(CLAIM_KEY_UID, id);
        claims.put(CLAIM_KEY_TID, tenantId);
        claims.put(CLAIM_KEY_ID, strTokenID);
        claims.put(CLAIM_KEY_USERTYPE, type);
        claims.put(CLAIM_KEY_CREATED, new Date());
        claims.put(CLAIM_KEY_NAME, name);
        claims.put(CLAIM_KEY_IP, ip);
        long t4 = System.currentTimeMillis();
        String token = generateTokenByClaims(claims, extendTime);
        long t3 = System.currentTimeMillis();

        if(extendTime == null){
            redisTemplate.opsForValue().set(strKey, token, expiration, TimeUnit.SECONDS);
        }else {
            redisTemplate.opsForValue().set(strKey, token, extendTime, TimeUnit.SECONDS);
        }
        long t2 = System.currentTimeMillis();
        log.info("创建token耗时={}", t2-t1);
        log.info("缓存redis耗时={}", t2-t3);
        log.info("生成token={}", t3-t4);
        return token;
    }

    public String generateToken(UserTokenVo userTokenVo) {
        return generateToken(userTokenVo.getTenantId(),
                userTokenVo.getUsername(),
                userTokenVo.getId(),
                userTokenVo.getType(),
                userTokenVo.getIp(),
                userTokenVo.getTokenType(),
                userTokenVo.getName(), null);
    }

    public String generateToken(UserTokenVo userTokenVo, long extendTime) {
        return generateToken(userTokenVo.getTenantId(),
                userTokenVo.getUsername(),
                userTokenVo.getId(),
                userTokenVo.getType(),
                userTokenVo.getIp(),
                userTokenVo.getTokenType(),
                userTokenVo.getName(), extendTime);
    }

    private String generateTokenByClaims(Map<String, Object> claims) {
        return generateTokenByClaims(claims, null);
    }

    private String generateTokenByClaims(Map<String, Object> claims, Long extendTime) {
        return Jwts.builder().setClaims(claims)
            .setExpiration(generateExpirationDate(extendTime))
            .signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encodeToString(secret.getBytes()))
                .compact();
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && !isTokenExpired(token);
    }

    public String refreshToken(String token, TokenType tokenType) {
        String userName = getUsernameFromToken(token);
        String tokenID = getValueFromToken(token, CLAIM_KEY_ID);
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(tokenID)) {
            return null;
        }
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String ip = IPUtil.getIp(request);
        String strKey = getKey(ip, userName, tokenID, tokenType);
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateTokenByClaims(claims);
            // tokenID 与token的映射
            redisTemplate.opsForValue().set(strKey, refreshedToken, expiration, TimeUnit.SECONDS);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public Boolean validateToken(String token, TokenType tokenType) {
        if (StringUtils.isBlank(token)) {
            return false;
        }
        final String tokenID = getValueFromToken(token, CLAIM_KEY_ID);
        final String username = getUsernameFromToken(token);
        if (username.isEmpty() || tokenID.isEmpty()) {
            return false;
        }
        // 过期判断
        if (isTokenExpired(token)) {
            return false;
        }

        // 非本系统登录验证,如OAuth2，不需要做登出判断
        String oauthType = getValueFromToken(token, CLAIM_KEY_OAUTHTYPE);
        if (!StringUtils.isEmpty(oauthType)) {
            return true;
        }

        // 本系统，判断是否已经登出
        String key = getKey(IPUtil.getIp(), username, tokenID, tokenType);
        Object existToken = redisTemplate.opsForValue().get(key);
        return (token.equals(existToken));
    }

    public Map<String, Object> validateTokenToRefresh(String token, TokenType tokenType){
        Map<String, Object> result = new HashMap<>();
        boolean flag = validateToken(token, tokenType);
        result.put("flag", flag);
        if(!flag){
            return result;
        }
        final Date expirationDate = getExpirationDateFromToken(token);
        Date checkDate = SaftopDate.getPreMin(new Date(), 30);
        if(expirationDate.before(checkDate)){
            // 过期时间小于30分钟， 重新生成token ，过期时间调整为60分钟
            final String username = getUsernameFromToken(token);
            final String tokenID = getValueFromToken(token, CLAIM_KEY_ID);
            String key = getKey(IPUtil.getIp(), username, tokenID, tokenType);
            UserTokenVo userTokenVo = new UserTokenVo(
                    getValueFromToken(token, CLAIM_KEY_TID),
                    username,
                    getValueFromToken(token, CLAIM_KEY_NAME),
                    getValueFromToken(token, CLAIM_KEY_UID),
                    getValueFromToken(token, CLAIM_KEY_USERTYPE),
                    IPUtil.getIp(),
                    tokenType
            );
            String newToken = generateToken(userTokenVo, EXTEND_TIME);
            if(StringUtils.isBlank(newToken)){
                log.error("创建新token 失败");
                result.put("flag", false);
                return result;
            }
            result.put("newToken", newToken);
            redisTemplate.delete(key);
        }
        return result;
    }

    private String getKey(String ip, String username, String tokenId, TokenType tokenType) {
        return tokenType + ":" + ip + ":" + username + ":" + tokenId;
    }
}

