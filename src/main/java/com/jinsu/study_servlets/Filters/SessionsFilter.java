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

// @WebFilter("/session/*") // 
// public class SessionsFilter implements Filter {

//     @Override
//     public void destroy() {
//         Filter.super.destroy();
//     }

//     @Override
//     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//             throws IOException, ServletException {
//         System.out.println(request.getRemoteHost());
//         System.out.println(request.getRemoteAddr());
//         HttpServletRequest httpServletRequest = (HttpServletRequest)request;
//         HttpServletResponse httpServletResponse = (HttpServletResponse)response;

//         String uri = httpServletRequest.getRequestURI();

//         chain.doFilter(request, response);// 이런식으로 넘겨준다
        
//     }

//     @Override
//     public void init(FilterConfig filterConfig) throws ServletException {
//     }
    
// }
