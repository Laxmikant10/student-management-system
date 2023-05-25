package com.lax.sms.controller;

import com.lax.sms.entity.Student;
import com.lax.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        //return view
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {

        //create Student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        //return view
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        //return view
        return "edit_student";

    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {

        //get student from DB by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //save updated Student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";

    }
}
