package com.itheima.dao;

import com.itheima.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll() throws Exception;

    void add(Category c) throws Exception;

    Category getById(String cid) throws Exception;

    void update(Category c) throws Exception;
}
