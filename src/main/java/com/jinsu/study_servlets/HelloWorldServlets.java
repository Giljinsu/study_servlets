package com.jinsu.study_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldServlets") // 별칭 어노테이션
public class HelloWorldServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String hiddenParam = request.getParameter("hiddenParam");
        String message = "HelloWorldServlets with Message !";
        PrintWriter printWriter = response.getWriter(); // 사용자한테 보내줄 html css, js를 보냄

        printWriter.println("<html lang='en'>"); // 메모리에 누적하고 후에 네트워크로 서버에 들어감
        printWriter.println("<head>");
        printWriter.println("<title>" + message + "</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<div> firstName : " + firstName + "</div>");
        printWriter.println("<div> secondName : " + secondName + "</div>");
        printWriter.println("<form action='/helloWorldServlets' method='get'>");
        printWriter.println("<input type='text' name='firstName' id='' value='" + firstName + "'>");
        printWriter.println("<input type='text' name='secondName' id='' value='" + secondName + "'>");
        printWriter.println("<button>recall helloWorldServlets</button>");
        printWriter.println("</form>");
        printWriter.println("</body>");
        printWriter.println("</html>");

        printWriter.close();
    }
}
