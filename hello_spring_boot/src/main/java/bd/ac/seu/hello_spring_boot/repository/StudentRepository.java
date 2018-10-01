package bd.ac.seu.hello_spring_boot.repository;

import bd.ac.seu.hello_spring_boot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByCgpaGreaterThanEqual(double gpa);
    Student findStudentByStudentName(String name);
    Student findStudentByStudentId(String id);

}
