package com.itheima;

import net.sf.json.JSONObject;
import org.junit.Test;
import net.sf.json.JSONArray;


import java.io.StringWriter;


public class domain {
    @Test
    public void f1(){
//        JSONArray jsonArray = JSONArray.fromObject();
    }
    public static void main(String[] args)
    {
        JSONObject obj = new JSONObject();

        obj.put("name","foo");
        obj.put("num",new Integer(100));
        obj.put("balance",new Double(1000.21));
        obj.put("is_vip",new Boolean(true));

        StringWriter out = new StringWriter();
        obj.writeJSONString(out);
        String jsonText = out.toString();
        System.out.print(jsonText);
    }
}
