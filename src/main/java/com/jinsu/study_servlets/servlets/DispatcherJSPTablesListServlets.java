package com.jinsu.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.jinsu.study_servlets.DatasInfo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherJSP/TablesListServlets")
public class DispatcherJSPTablesListServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        DatasInfo datasInfo = new DatasInfo();
        ArrayList<String> tablesListWithString = datasInfo.getTablesListData();
        HashMap<String, String> searchForm =  datasInfo.getSearchFormhData();
        request.setAttribute("tablesListWithString", tablesListWithString); //request에 저장
        request.setAttribute("searchForm", searchForm);
        

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/tables_list.jsp");
        requestDispatcher.forward(request, response);
       
        printWriter.close();
    }    
}
