package com.itheima.service.impl;

import com.itheima.dao.CategoryDao;
import com.itheima.dao.impl.CategoryDaoImpl;
import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import com.itheima.utils.BeanFactory;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.io.InputStream;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    /**
     * 查询所的有分类
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Category> findAll() throws Exception {
        //1,创建缓存管理器
        CacheManager cm = CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));

        //2,获取指定的缓存
        Cache cache = cm.getCache("categoryCache");

        //3,通过缓存获取数据 将cache看成一个map即可
        Element element = cache.get("clist");

        List<Category> list = null;

        //4,判断数据
        if (element == null) {
            //从数据库中获取
            CategoryDao cd = new CategoryDaoImpl();
            list = cd.findAll();

            //将list放入缓存
            cache.put(new Element("clist", list));

            System.out.println("缓存中没有数据,已去数据库中获取");
        } else {
            //直接返回
            list = (List<Category>) element.getObjectValue();

            System.out.println("缓存中有数据");
        }

        return list;
    }

    /**
     * 添加分类
     * @param c
     * @throws Exception
     */
    @Override
    public void add(Category c) throws Exception {
        //暂时获取dao
        CategoryDao cd = (CategoryDao) BeanFactory.getBean("CategoryDao");
        cd.add(c);
    }

    public static void main(String[] args) {
        InputStream is = CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml");
        System.out.println(is);
    }
}
