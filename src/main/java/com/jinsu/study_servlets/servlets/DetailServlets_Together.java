package com.jinsu.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.jinsu.study_servlets.dao.pollWithDB_Together;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/polls/PollServlet")
public class DetailServlets_Together extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // input type
        String questions_Uid = request.getParameter("QUESTIONS_UID");

        // biz with DB and Class
        pollWithDB_Together pollWithDB = new pollWithDB_Together();
        HashMap<String, Object> question = null;
        ArrayList<HashMap> answer_List = null;
        try {
            question = pollWithDB.getQuestion(questions_Uid);
            System.out.println(question.get("QUESTIONS_UID"));
            System.out.println(question.get("QUESTIONS"));
            System.out.println(question.get("ORDERS"));
            answer_List =pollWithDB.getAnswer(questions_Uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i =0 ; i< answer_List.size();i++) {
            HashMap<String,Object> answer =  answer_List.get(i);
            System.out.print(answer.get("ORDERS"));
            System.out.println(answer.get("EXAMPLE"));
        }
        // output with html
        request.setAttribute("question", question);
        request.setAttribute("answer_List", answer_List);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/poll/details_together.jsp");
        requestDispatcher.forward(request, response);
    }
}