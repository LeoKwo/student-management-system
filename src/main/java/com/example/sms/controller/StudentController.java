package com.example.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;


@Controller
public class StudentController {

    private StudentService studentService; // Java Bean

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    //	List all students
    @GetMapping("/list")
    public String listStudents(Model model) {
        // NullPointerException
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    //	add student
    @GetMapping("/list/new")
    public String createStudentForm(Model model) {

        // created student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    //	save student
    @PostMapping("/list")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/list";
    }

    //	update student from page
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student existingStudent = studentService.getStudentById(id);
        model.addAttribute("student", existingStudent);
        return "edit_student";
    }


    //	update student actual
    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {
        // Get Student details from database
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save updated student object
        studentService.updateStudent(existingStudent);

        return "redirect:/list";
    }

    // delete student
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/list";
    }

}
















