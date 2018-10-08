package com.itheima.service;

import com.itheima.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll() throws Exception;

    void add(Category c) throws Exception;

    Category getById(String cid) throws Exception;

    void update(Category c) throws Exception;

    void delete(String cid) throws Exception;
}
