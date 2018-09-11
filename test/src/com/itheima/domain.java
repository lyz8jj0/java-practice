package com.itheima;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class domain {

    @Test
    public void f1(){
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.setTime(cal.getTime());
        cal.add(Calendar.MONTH, -1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(cal.getTime()));
    }


    @Test
    public void f2(){
        Calendar instance =  Calendar.getInstance();
        System.out.println(instance.get(Calendar.YEAR));//1
        System.out.println(instance.get(Calendar.MONTH));//2
    }

    @Test
    public void f3(){
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.setTime(cal.getTime());
        cal.add(Calendar.MONTH, +1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println( formatter.format(cal.getTime()));
    }

}
