package bd.ac.seu.hello_spring_boot;

import bd.ac.seu.hello_spring_boot.model.Student;
import bd.ac.seu.hello_spring_boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HelloSpringBootApplication {
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}

	@Bean
	CommandLineRunner runner () {
		return args -> {
//			Student student = new Student("2", "June", 3.60);
//			studentRepository.save(student);
//			studentRepository.findAll().forEach(System.out::println);
//			studentRepository.findByCgpaGreaterThanEqual(3.50).forEach(System.out::println);
            System.out.println(studentRepository.findStudentByStudentName("bashar"));
		};
	}
}
