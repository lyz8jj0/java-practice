package com.itheima.f_path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "PathServlet", urlPatterns = {"/paht"})
public class PathServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

   public static void main(String[] args) {
       //String pt = PathServlet.class.getClassLoader().getResource("1.txt").getPath();
       InputStream is = PathServlet.class.getClassLoader().getResourceAsStream("/1.txt");
       System.out.println(is);
   }
}
