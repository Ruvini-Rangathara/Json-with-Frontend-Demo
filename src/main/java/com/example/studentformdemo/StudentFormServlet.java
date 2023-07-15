package com.example.studentformdemo;

import com.example.studentformdemo.dto.StudentFormDTO;
import com.example.studentformdemo.model.StudentModel;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class StudentFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentModel studentModel = new StudentModel();


        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String email = req.getParameter("email");
        int level = Integer.parseInt(req.getParameter("level"));


        StudentFormDTO studentFormDTO = new StudentFormDTO(name, city, email, level);
        System.out.println(studentFormDTO.toString());

        if(studentModel.save(studentFormDTO)){
            System.out.println("\nSaved.");
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }

    }



}
