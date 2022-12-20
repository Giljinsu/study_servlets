package com.jinsu.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherJSPServlets") // 별칭 어노테이션
public class DispatcherJSPServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String hiddenParam = request.getParameter("hiddenParam");
        
        
            request.setAttribute("firstName", "jinsu"); // 어트리뷰트 생성 파라미터는 브라우저에서 날라오는것 
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/search_form.jsp");
            requestDispatcher.forward(request, response);
       
    }
}
