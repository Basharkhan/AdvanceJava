package bd.ac.seu.OrmDemo.Service;

import bd.ac.seu.OrmDemo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentService {

    SessionFactory sessionFactory;

    public StudentService() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public void addStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        session.save(student);

        session.getTransaction().commit();
    }

    public void insertStudents(List<Student> studentList) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        studentList.forEach(student -> session.save(student));
        session.getTransaction().commit();
    }

    public List<Student> getStudentList() {
        List<Student> studentList;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student");
        studentList = query.getResultList();
        return studentList;
    }

    public List<Course> getCourseList() {
        List<Course> courseList;
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from Course");
        courseList = query.getResultList();
        session.getTransaction().commit();

        return courseList;
    }

    public Student getStudent(int studentId) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        Student student = session.get(Student.class,studentId);

        session.getTransaction().commit();
        return student;
    }

    public void updateStudent(int studentId, Name name, Address address, String emailAddress, Sex sex) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Student student = session.get(Student.class, studentId);
        student.setName(name);
        student.setEmailAddress(emailAddress);
        student.setAddress(address);
        student.setSex(sex);
        session.update(student);
        session.getTransaction().commit();
    }

    public void deleteStudent(int studentId) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Student student = session.get(Student.class, studentId);
        session.delete(student);
        session.getTransaction().commit();
    }

}
