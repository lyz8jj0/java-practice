package com.itheima;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JSON字符串自动转换 * Created by zkn on 2016/8/22.
 */
public class JsonTest {
    //    public static void main(String[] args) {
//        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//        String name = f.format(new Date()) + ".png";
//        System.out.println(name);
//    }
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("姚明");
        coll.add("科比");
        coll.add("麦迪");
        coll.add("詹姆斯");
        coll.add("艾弗森");
        Iterator<String> it = coll.iterator();
        while (it.hasNext()) {
            String e = it.next();
            System.out.println(e);
        }
    }
}

