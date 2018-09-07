package com.itheima.myconventer;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MyConventer implements Converter {
    @Override
    public Object convert(Class clazz, Object value) {
        //class 要装成的类型
        //object 页面上传入的值

        //将object转成data
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse((String) value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
