package bd.ac.seu.hello_spring_boot.controller;

import bd.ac.seu.hello_spring_boot.model.Student;
import bd.ac.seu.hello_spring_boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/bashar")
    @ResponseBody
    public String handleSomething() {
        return "Hello Bashar !";
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String handleIt(@RequestParam String name) {
        return "Hello " + name + " ";
    }

    @RequestMapping(value = "/students")
    public String getStudentList(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }

    @RequestMapping(value = "/student/{id}")
    public String student(@PathVariable String id, Model model) {
        model.addAttribute("student", studentRepository.findOne(id));
        return "student";
    }

    @RequestMapping(value = "/insert_student")
    @ResponseBody
    public String insertStudent(@RequestParam String id, String name, double cgpa) {
        studentRepository.save(new Student(id, name, cgpa));
        return "Successfull";
    }
}
