package bd.ac.seu.hello_spring_boot.controller;

import bd.ac.seu.hello_spring_boot.model.Student;
import bd.ac.seu.hello_spring_boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ApiController {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/students")
    public List<Student> getStudentList() {
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        System.out.println(userDetails.getUsername());
//        System.out.println(userDetails.getPassword());
//        authentication.getAuthorities().forEach(System.out::println);

        return studentRepository.findAll();
    }

    @RequestMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) {
        return studentRepository.findOne(id);
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public Student addStudent(@RequestParam String studentId,
                           @RequestParam String studentName,
                           @RequestParam double cgpa) {
        System.out.println("addStudent got called");
        System.out.println("studentId = " + studentId);
        System.out.println("studentName = " + studentName);
        System.out.println("cgpa = " + cgpa);
        Student student = new Student(studentId, studentName, cgpa);
        return studentRepository.save(student);
    }

    @RequestMapping(value = "/student/{studentId}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable String studentId) {
        Student student = studentRepository.findOne(studentId);
        studentRepository.delete(student);
        System.out.println("Delete got called");
    }

    @RequestMapping(value = "/student/{studentId}/{name}/{cgpa}", method = RequestMethod.PUT)
    public void updateStudent(@PathVariable String studentId,
                              @PathVariable String name,
                              @PathVariable double cgpa) {
        Student student = studentRepository.findOne(studentId);
        student.setStudentName(name);
        student.setCgpa(cgpa);
        studentRepository.save(student);
        System.out.println("Update got called");
    }
}
