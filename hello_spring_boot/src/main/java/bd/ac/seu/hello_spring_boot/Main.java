package bd.ac.seu.hello_spring_boot;

import bd.ac.seu.hello_spring_boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Main {
    @Autowired
    StudentRepository studentRepository;

    public Main() {
        System.out.println(studentRepository.findByCgpaGreaterThanEqual(3.5));
        System.out.println("Hello world");
    }

    public static void main(String args[]) {
        new Main();
    }
}
