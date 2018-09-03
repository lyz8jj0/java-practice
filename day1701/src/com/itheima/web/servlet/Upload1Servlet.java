package com.itheima.web.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


@WebServlet(name = "Upload1Servlet", urlPatterns = {"/upload1"})
@MultipartConfig
public class Upload1Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取username
        String username = request.getParameter("username");
        System.out.println(username);

//        //获取f 获取的内容为null
//        String f = request.getParameter("f");
//        System.out.println(f);

        Part part = request.getPart("f");
//        System.out.println(part);
        String name = part.getName();

        //获取name的值
        //System.out.println(name);

        String dis = part.getHeader("content-disposition");
        String s = dis.substring(dis.indexOf("filename=") + 10, dis.length() - 1);
        System.out.println(s);

        InputStream is = part.getInputStream();
        FileOutputStream os = new FileOutputStream("f:/" + s);
        IOUtils.copy(is, os);

        os.close();
        is.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
