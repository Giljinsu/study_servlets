package com.jinsu.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies/createServlets")
public class CreateCookieServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Cookie
        Cookie cookie_first = new Cookie("firstName", "Gil");
        Cookie cookie_second = new Cookie("secondName", "Jinsu");
        response.addCookie(cookie_first);
        response.addCookie(cookie_second);
        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>CreateCookieServlets</div>");
        printWriter.close();

    }
}
