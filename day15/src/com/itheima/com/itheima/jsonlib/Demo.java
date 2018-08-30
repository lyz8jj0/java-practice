package com.itheima.com.itheima.jsonlib;

import com.itheima.domain.Province;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {

    @Test
    //数组
    public void f1() {
        String[] arr = {"aaa", "bbb", "cc"};
        JSONArray json = JSONArray.fromObject(arr);
        System.out.println(json); //["aaa","bbb","cc"]
    }

    @Test
    //list
    public void f2() {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("22");
        list.add("33");
        JSONArray json = JSONArray.fromObject(list);
        System.out.println(json); //["11","22","33"]
    }

    @Test
    //bean
    public void f3() {
        Province pro = new Province();
        pro.setName("北京");
        pro.setProvinceid(1);
        JSONObject json = JSONObject.fromObject(pro);
        System.out.println(json); //{"name":"北京","provinceid":1}
    }

    @Test
    //map
    public void f4() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "tom");
        map.put("age", 18);
        JSONObject json = JSONObject.fromObject(map);
        System.out.println(json); //{"age":18,"username":"tom"}
    }

    @Test
    //list里面放bean
    public void f5() {
        List<Province> list = new ArrayList<>();
        list.add(new Province(1, "bj"));
        list.add(new Province(2, "tj"));
        list.add(new Province(3, "nj"));
        list.add(new Province(4, "dj"));
        JSONArray json = JSONArray.fromObject(list);
        System.out.println(json); //[{"name":"bj","provinceid":1},{"name":"tj","provinceid":2},{"name":"nj","provinceid":3},{"name":"dj","provinceid":4}]
    }
}
