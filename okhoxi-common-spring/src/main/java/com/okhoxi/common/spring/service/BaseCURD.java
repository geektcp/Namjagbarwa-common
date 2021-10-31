package com.okhoxi.common.spring.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import com.okhoxi.common.spring.jpa.JpaBase;
import com.okhoxi.common.spring.model.dto.PageResponseDTO;
import com.okhoxi.common.spring.model.vo.HttpContextInfo;
import com.okhoxi.common.spring.util.EntityUtils;
import com.okhoxi.common.spring.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public class BaseCURD<M extends Mapper<T>, T> extends JpaBase {
    @Autowired
    protected M mapper;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }


    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }


    public List<T> selectListAll() {
        return mapper.selectAll();
    }


    public Long selectCount(T entity) {
        return new Long(mapper.selectCount(entity));
    }


    public void insert(T entity) {
        EntityUtils.setCreatAndUpdatInfo(entity);
        mapper.insert(entity);
    }


    public void insertSelective(T entity) {
        EntityUtils.setCreatAndUpdatInfo(entity);
        mapper.insertSelective(entity);
    }


    public void delete(T entity) {
        mapper.delete(entity);
    }


    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
    }


    public void updateById(T entity) {
        EntityUtils.setUpdatedInfo(entity);
        mapper.updateByPrimaryKey(entity);
    }


    public void updateSelectiveById(T entity) {
        EntityUtils.setUpdatedInfo(entity);
        mapper.updateByPrimaryKeySelective(entity);

    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }

    public PageResponseDTO<T> selectByQuery(Query query) {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        example.setOrderByClause("sort asc");
        Example.Criteria criteria = example.createCriteria();
        for (Map.Entry<String, Object> entry : query.entrySet()) {

            if (entry.getKey().equals("tenantId")) {
                criteria.andEqualTo(entry.getKey(), entry.getValue());
            } else {
                criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
            }
        }
        Page<Object> result = PageMethod.startPage(query.getPage(), query.getLimit());
        List<T> list = mapper.selectByExample(example);
        PageResponseDTO<T> ret = new PageResponseDTO<>();
        ret.setPage(list, result.getTotal(),result.getPageNum(),result.getPageSize());
        return ret;
    }

    public PageResponseDTO<T> selectByQueryEqual(Query query) {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        for (Map.Entry<String, Object> entry : query.entrySet()) {
            criteria.andEqualTo(entry.getKey(), entry.getValue());
        }
        Page<Object> result = PageMethod.startPage(query.getPage(), query.getLimit());
        List<T> list = mapper.selectByExample(example);
        PageResponseDTO<T> ret = new PageResponseDTO<>();
        ret.setPage(list, result.getTotal(),result.getPageNum(),result.getPageSize());
        return ret;
    }

    // 以下方法主要用于异步的业务，具体流程如下：
    // 1. 在异步操作之前，调用EntityUtils#getHttpContextInfo()初始化一个HttpContextInfo
    // 2. 在调用添加、修改方法的时候，把HttpContextInfo对象作为参数传入
    // start ......................... .........................
    public void insert(T entity, HttpContextInfo info) {
        EntityUtils.setCreatAndUpdatInfo(entity, info);
        mapper.insert(entity);
    }

    public void insertSelective(T entity, HttpContextInfo info) {
        EntityUtils.setCreatAndUpdatInfo(entity, info);
        mapper.insertSelective(entity);
    }

    public void updateById(T entity, HttpContextInfo info) {
        EntityUtils.setUpdatedInfo(entity, info);
        mapper.updateByPrimaryKey(entity);
    }


    public void updateSelectiveById(T entity, HttpContextInfo info) {
        EntityUtils.setUpdatedInfo(entity, info);
        mapper.updateByPrimaryKeySelective(entity);
    }
    // end ......................... .........................
}
