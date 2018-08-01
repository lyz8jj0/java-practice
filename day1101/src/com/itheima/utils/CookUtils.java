package com.itheima.utils;

import javax.servlet.http.Cookie;

/**
 * Created by Administrator on 2018/8/1.
 */
public class CookUtils {
    /**
     * 通过名称在cookie数组获取指定的cookie
     *
     * @param name    cookie名称
     * @param cookies cookies数组
     * @return
     */
    public static Cookie getCookieByName(String name, Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (name.equals(c.getName())) {
                    return c;
                }
            }
        }
        return null;
    }
}
