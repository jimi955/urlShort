package com.xiaoxin.urlshorter.repository;

import com.xiaoxin.urlshorter.entity.UrlShort;
import org.springframework.data.jpa.repository.JpaRepository;

// 继承JpaRepository来完成对数据库的操作   UrlShort 数据封装的类型  Inaterger 主键的类型
public interface UrlShortRepository extends JpaRepository<UrlShort,Integer> {
    UrlShort findByLonger(String url);

    UrlShort findByShorter(String sid);
}
