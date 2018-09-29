package com.itheima;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

public class domain {

    @Test
    public void f1() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.setTime(cal.getTime());
        cal.add(Calendar.MONTH, -1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(cal.getTime()));
    }


    @Test
    public void f2() {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.get(Calendar.YEAR));//1
        System.out.println(instance.get(Calendar.MONTH));//2
    }

    @Test
    public void f3() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.setTime(cal.getTime());
        cal.add(Calendar.MONTH, +1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(cal.getTime()));
    }

    @Test
    public void f4() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.setTime(cal.getTime());
        cal.add(Calendar.MONTH, -2);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(cal.getTime()));
    }

    //获得本周星期日的日期
    @Test
    public void f5() {
        int mondayPlus = this.getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
        Date monday = currentDate.getTime();
//        DateFormat df = DateFormat.getDateInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String preMonday = formatter.format(monday);
        System.out.println(preMonday);
    }

    @Test
    public void f6() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 可以方便地修改日期格式
        String hehe = dateFormat.format(now);
        System.out.println(hehe);
    }


    /**
     * 获得当前日期与本周日相差的天数
     *
     * @return
     */
    private int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 1) {
            return 0;
        } else {
            return 1 - dayOfWeek;
        }
    }


    /**
     * 计算当月最后一天,返回字符串
     *
     * @return
     */
    @Test
    public void getDefaultDay() {
        String str;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
        lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
        lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天

        str = sdf.format(lastDate.getTime());
        System.out.println(str);
    }

    @Test
    public void f666() {
        String str = "{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}";
        //第一种方式  
        Map maps = (Map) JSON.parse(str);
        System.out.println("这个是用JSON类来解析JSON字符串!!!");
        for (Object map : maps.entrySet()) {
            System.out.println(((Map.Entry) map).getKey() + " " + ((Map.Entry) map).getValue());
        }





    }


}
