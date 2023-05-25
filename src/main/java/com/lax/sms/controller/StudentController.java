package com.lax.sms.controller;

import com.lax.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //handler method to handle list of student and return model and view
    @GetMapping("/students")
    public String listOfStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }
}
