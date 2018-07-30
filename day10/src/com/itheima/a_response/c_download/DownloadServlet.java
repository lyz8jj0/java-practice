package com.itheima.a_response.c_download;


import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;


/**
 * 文件下载
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/download"})
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取下载文件的名称
        String filename = request.getParameter("name");

        ServletContext context = this.getServletContext();
        //文件下载
        //1，设置文件的mimeType
        String mimeType = context.getMimeType(filename);
        response.setContentType(mimeType);

        //2，设置下载的头信息
        response.setHeader("content-disposition", "attchment;filename=" + filename);

        //3，对拷流
        //获取输入流
        InputStream is = context.getResourceAsStream("/download/" + filename);

        //获取输出流
        ServletOutputStream os = response.getOutputStream();

     /*   int len = 1;
        byte[] b = new byte[1024];

        while ((len=is.read(b))!=-1){
            os.write(b,0,len);
        }*/


        IOUtils.copy(is, os);

        os.close();
        is.close();
    }
}
