package com.okhoxi.common.spring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by Mr.Tang on 2018/12/25.
 */
@NoRepositoryBean
public interface JpaRepo<T> extends JpaRepository<T, Long>,
        JpaSpecificationExecutor<T>,
        QueryDslPredicateExecutor<T> {
}
