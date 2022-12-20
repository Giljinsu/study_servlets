package com.jinsu.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies/getAndDeleteServlets")
public class GetAndDeleteCreateCookieServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>GetAndDeleteServlets</div>");
        
        // Cookie
        Cookie cookies[] = request.getCookies(); //한번에 다 와서 리스트가 들어가야함
        for(Cookie cookie : cookies) {
            String name = cookie.getName();// 키값
            String value = cookie.getValue(); // 값
            printWriter.println("<div>Cookie Name : "+name+", value "+value+" </div>");

            //삭제
            if(name.equals("secondName")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        printWriter.close();

    }
}
