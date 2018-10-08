package com;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "Demo1Servlet", urlPatterns = {"/demo1"})
public class Demo1Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");

        //创建磁盘文件项工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();

        //创建核心上传对象
        ServletFileUpload upload = new ServletFileUpload(factory);

        //解析请求
        try {
            List<FileItem> list = upload.parseRequest(req);
            //遍历list
            for (FileItem fi : list) {
                //判断是普通的上传还是文件上传
                if (fi.isFormField()) {
                    //普通上传组件
                    //获取name属性
                    String name = fi.getFieldName();

                    String string = fi.getString("utf-8");

                    System.out.println(name + "::" + string);
                } else {
                    //文件上传组件
                    //获取name属性
                    String name = fi.getFieldName();

                    //获取文件的名称
                    String filename = fi.getName();

                    //获取文件内容
                    InputStream is = fi.getInputStream();

                    System.out.println("文件:" + name + "::" + filename + "::" + is);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
