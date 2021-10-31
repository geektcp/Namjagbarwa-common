package com.okhoxi.common.spring.model.vo;

import com.okhoxi.common.spring.constant.TokenType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mr.Tang on 2021/1/21 13:41.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTokenVo {
    String tenantId;
    String username;
    String name;
    String id;
    String type;    // user type
    String ip;
    TokenType tokenType;  // token type
}
