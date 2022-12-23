package com.jinsu.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.web.servlet.support.RequestDataValueProcessor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// /session/createJSPServlets?username=yojulab&password=1234
@WebServlet(urlPatterns="/session/createJSPServlets")
public class CreateSessionJSPServlets extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // login 
        HttpSession httpSession = null; // 세션들 불러옴
        HttpSession httpSession_false= null;
        
        // EXISTS JSESSIONID
        // httpSession_false = request.getSession(false); // 존재하면 인스턴스화
        // httpSession =request.getSession(); //무조건 인스턴스화

        // NOT EXISTS JSESSIONID
        // httpSession_false = request.getSession(false);
        // httpSession =request.getSession();

        String path = null;
        if("yojulab".equals(username) && "1234".equals(password)){ //이런식으로 써야  null체크까지 가능
            //login
            httpSession = request.getSession(false); // 존재하면 인스턴스화
            if(httpSession ==null) { // session이 없으면
                httpSession =request.getSession(); //생성
                httpSession.setAttribute("username", username); // httpSession에 저장
                httpSession.setAttribute("password", password);
            }
            
            System.out.println(httpSession.getAttribute("username"));
            System.out.println(httpSession.getId());

            path = "/session/checkLogin.jsp";
        } else {
            //logout
            httpSession = request.getSession(false);
            if(httpSession != null) {
                httpSession.invalidate();
            }
            System.out.println(httpSession.getAttribute("username")); // invalid되서 못가져옴
            System.out.println(httpSession.getId());

            path = "/session/checkLogout.jsp";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}