package com.okhoxi.common.spring.controller;

import com.okhoxi.common.spring.model.dto.PageResponseDTO;
import com.okhoxi.common.spring.model.dto.ResponseDTO;
import com.okhoxi.common.spring.service.BaseCURD;
import com.okhoxi.common.spring.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

@Deprecated
public class BaseController<Biz extends BaseCURD, Entity> {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected Biz baseService;

    @PostMapping("")
    @ResponseBody
    public ResponseDTO<Object> add(@RequestBody Entity entity) {
        baseService.insertSelective(entity);
        return ResponseDTO.success(entity);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseDTO<Object> get(@PathVariable int id) {
        return ResponseDTO.success(baseService.selectById(id));
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseDTO<Object> update(@RequestBody Entity entity) {
        baseService.updateSelectiveById(entity);
        return ResponseDTO.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseDTO<Object> remove(@PathVariable int id) {
        baseService.deleteById(id);
        return ResponseDTO.success();
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseDTO<List<Object>> all() {
        return ResponseDTO.success(baseService.selectListAll());
    }

    @GetMapping("/page")
    @ResponseBody
    public PageResponseDTO<Object> list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        return baseService.selectByQuery(query);
    }

    @GetMapping("/pageEqual")
    @ResponseBody
    public PageResponseDTO<Object> listEqual(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        return baseService.selectByQueryEqual(query);
    }

    public String getCurrentUserName() {
        String authorization = request.getHeader("Authorization");
        return new String(Base64Utils.decodeFromString(authorization));
    }

    public String getCurUID() {
        return request.getHeader("userId");
    }

    public String getCurTenantId() {
        return request.getHeader("tenantId");
    }

    public String getCurUType() {
        return request.getHeader("userType");
    }

}
