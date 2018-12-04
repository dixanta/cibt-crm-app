/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.web.controller;

import com.cibt.web.dao.StudentDAO;
import com.cibt.web.entity.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;
    
    @GetMapping()
    @ResponseBody
    public List<Student> index(){
        return studentDAO.getAll();
    }
    
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Student detail(@PathVariable("id")int id){
        return studentDAO.getById(id);
    }
    
    @GetMapping(value="/add")
    @ResponseBody
    public String add(){
        Student student=new Student();
        student.setId(2);
        student.setFirstName("Pratikshya");
        student.setLastName("Shrestha");
        student.setEmail("prati@gmail.com");
        student.setContactNo("979797");
        studentDAO.save(student);
        return "Id: " + student.getId();
    }
    
}
