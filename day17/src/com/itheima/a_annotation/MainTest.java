package com.itheima.a_annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTest {
//    public static void main(String[] args) {
//        //运行这个类的时候需要将测试类中带有@MyTest所有方法执行
//        Class clazz = MyTestTest.class;
//
//        //获取所的方法
//        Method[] arr = clazz.getMethods();
//
//        //让方法执行
//        for (Method m : arr) {
//            //打印所的方法名称
//            System.out.println(m.getName());
//        }
//    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        //运行这个类的时候 需要将测试类中带有@MyTest所的方法执行
        //获取字节码对象
        Class clazz = MyTestTest.class;

        //获取所的的方法
        Method[] arr = clazz.getMethods();

        //让带有注解的方法执行
        for (Method m : arr) {
            //获取有注解的方法

            //判断方法是否有指定的注解
            boolean flag = m.isAnnotationPresent(MyTest.class);
            if (flag) {
//                System.out.println(m.getName());
                m.invoke(clazz.newInstance());
            }
        }

    }
}
