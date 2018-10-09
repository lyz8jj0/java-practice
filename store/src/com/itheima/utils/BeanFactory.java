package com.itheima.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 实体工厂类
 */
public class BeanFactory {
    public static Object getBean(String id) {
        //通过id获取一个指定的实现类

        try {
            //1,获取document对象
            Document doc = new SAXReader().read(BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml"));

            //2,获取指定的bean对象
            Element ele = (Element) doc.selectSingleNode("//bean[@id='" + id + "']");

            //3,获取bean对象的class属性
            String value = ele.attributeValue("class");

            //4,反射 以前的逻辑返回的是实例
//            return Class.forName(value).newInstance();

            //5,现在对service中add方法进行加强 返回值是代理对象
            final Object obj = Class.forName(value).newInstance();
            //server的实现类
            if (id.endsWith("Service")) {
                Object proxyObj = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //继续间断是否调用的add方法或者regist方法
                        if ("add".equals(method.getName()) || "regist".equals(method.getName())) {
                            System.out.println("添加操作");
                            return method.invoke(obj, args);
                        }
                        return method.invoke(obj, args);
                    }
                });

                //若是service方法返回的是代理对象
                return proxyObj;
            }
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getBean("ProductDao"));
    }
}
