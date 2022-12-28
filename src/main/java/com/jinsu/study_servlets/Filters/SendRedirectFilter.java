// package com.jinsu.study_servlets.Filters;

// import java.io.IOException;

// import jakarta.servlet.Filter;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.FilterConfig;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.ServletRequest;
// import jakarta.servlet.ServletResponse;
// import jakarta.servlet.annotation.WebFilter;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @WebFilter("/simple/*")
// public class SendRedirectFilter implements Filter{
//     @Override
//     public void destroy() {
//     }

//     @Override
//     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//             throws IOException, ServletException {
//         System.out.println(request.getRemoteHost());
//         System.out.println(request.getRemoteAddr());
//         HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//         HttpServletResponse httpServletResponse = (HttpServletResponse) response;

//         String uri = httpServletRequest.getRequestURI();

//         if(uri.endsWith("Servlets")){
//             httpServletResponse.sendRedirect("/index.html");
//             // sendRedirect나 포워드는 웹서버에 요청하는것
//             // 웹서버는 웹서버를 또 실행 그래서 필터 두번 작동하는것처럼 보임
//         } else {
//             chain.doFilter(request, response);
//         }

//     }
//     @Override
//     public void init(FilterConfig filterConfig) throws ServletException {
//     }
// }

