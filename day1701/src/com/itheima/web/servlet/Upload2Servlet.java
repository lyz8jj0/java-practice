package com.itheima.web.servlet;

import com.itheima.utils.UploadUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Administrator
 */
@WebServlet(name = "Upload2Servlet", urlPatterns = {"/upload2"})
@MultipartConfig
public class Upload2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0,设置编码
        request.setCharacterEncoding("utf-8");

        //1,获取普通的上传组件 username
//        String username = request.getParameter("username");
//        System.out.println(username);
        String username = request.getParameter("username");
        System.out.println(username);

        //2,获取文件上传组件
        Part part = request.getPart("f");
        //2.1获取文件的名称
        String sss = part.getHeader("content-disposition");
        String realName = sss.substring(sss.indexOf("filename=") + 10, sss.length() - 1);

        System.out.println("文件的名称L:" + realName);

        //2.2 获取随机名称
        String uuidName = UploadUtils.getUUIDName(realName);
        System.out.println("文件随机名称:" + uuidName);

        //2.3获取文件存放的目录
        String dir = UploadUtils.getDir(uuidName);
        String realPath = this.getServletContext().getRealPath("/upload" + dir);
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        System.out.println("文件的目录" + realPath);

        //3,对拷流
        InputStream is = part.getInputStream();
        FileOutputStream os = new FileOutputStream(new File(file, uuidName));
        IOUtils.copy(is, os);
        os.close();
        is.close();

        //删除临时文件
        part.delete();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
