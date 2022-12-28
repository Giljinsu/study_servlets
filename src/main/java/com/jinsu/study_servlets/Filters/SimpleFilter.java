// package com.jinsu.study_servlets.Filters;

// import java.io.IOException;

// import jakarta.servlet.Filter;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.FilterConfig;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.ServletRequest;
// import jakarta.servlet.ServletResponse;
// import jakarta.servlet.annotation.WebFilter;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @WebFilter("/*") // 모든것을 다 검열하곘다
// public class SimpleFilter implements Filter {

//     @Override
//     public void destroy() {
//         Filter.super.destroy();
//     }

//     @Override
//     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//             throws IOException, ServletException {
//         System.out.println(request.getRemoteHost());
//         System.out.println(request.getRemoteAddr());
//         chain.doFilter(request, response);
//     }

//     @Override
//     public void init(FilterConfig filterConfig) throws ServletException {
//     }
    
// }
