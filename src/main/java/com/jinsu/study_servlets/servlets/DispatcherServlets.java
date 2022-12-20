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

@WebServlet(urlPatterns = "/dispatcherServlets") // 별칭 어노테이션
public class DispatcherServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String hiddenParam = request.getParameter("hiddenParam");
        
        // /dispatcherServlets?hiddenParam=searchFormServlet
        if("searchFormServlet".equals(hiddenParam)) {
            response.sendRedirect("/searchFormServlet"); // 방향바꾸기 searchFormServlet으로보냄 파라미터 포함 x 즉 hiddenParam은 안보내짐
        // /dispatcherServlets?hiddenParam=createCookieServlets
        } else if("createCookieServlets".equals(hiddenParam)) {
            request.setAttribute("firstName", "jinsu"); // 어트리뷰트 생성 파라미터는 브라우저에서 날라오는것 
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cookies/createServlets");
            requestDispatcher.forward(request, response);
        } else {
            //normal display
            String message = "DispatcherServlets with Message !";
            PrintWriter printWriter = response.getWriter(); // 사용자한테 보내줄 html css, js를 보냄
    
            printWriter.println("<html lang='en'>"); // 메모리에 누적하고 후에 네트워크로 서버에 들어감
            printWriter.println("<head>");
            printWriter.println("<title>" + message + "</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<button>call dispatcherServlets</button>");
            printWriter.println("</form>");
            printWriter.println("</body>");
            printWriter.println("</html>");
            
            printWriter.close();
        }

    }
}
