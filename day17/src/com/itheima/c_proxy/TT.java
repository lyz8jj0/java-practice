package com.itheima.c_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TT {
    public static void main(String[] args) {
        final QQ qq = new QQ();
//        qq.run();
//        qq.stop();
        Car qqProxy = (Car) Proxy.newProxyInstance(QQ.class.getClassLoader(), new Class[]{Car.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("哈哈哈哈");
//                System.out.println(method.getName());
//                obj就是代理对象
//                Object obj = method.invoke(qq, args);
//                return obj;

                //对所有方法时行加强
//                System.out.println("加上电池");
//                Object obj = method.invoke(qq, args);
//                System.out.println("5秒破百");


                //只对run方法进行加强
                if ("run".equals(method.getName())) {
                    System.out.println("加上电池");
                    System.out.println("5秒破百");
                    Object obj = method.invoke(qq, args);
                    return obj;
                } else {
                    return method.invoke(qq,args);
                }


            }
        });
        qqProxy.run();
//        qqProxy.stop();
    }
}
