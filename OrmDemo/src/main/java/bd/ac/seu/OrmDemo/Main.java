package bd.ac.seu.OrmDemo;

import bd.ac.seu.OrmDemo.Service.StudentService;
import bd.ac.seu.OrmDemo.Util.Filter;
import bd.ac.seu.OrmDemo.Util.TestInterface;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private String generateRandomName() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = (int)(Math.random() * 10 + 3);
        stringBuilder.append((char) (Math.random() * 26 + 'A'));
        for(int i = 0; i <= length; i++) {
            stringBuilder.append((char) (Math.random() * 26 + 'a'));
        }
        return stringBuilder.toString();
    }

    private String generateRandomEmailAddress() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = (int) (Math.random() * 5 + 3);
        for(int i = 0; i <= length; i++) {
            stringBuilder.append((char) (Math.random() * 26 + 'a'));
        }
        stringBuilder.append("@gmail.com");
        return stringBuilder.toString();
    }

    //Main class
    public Main() {
        StudentService studentService = new StudentService();
//        studentService.deleteStudent(2);
//        studentService.updateStudent(7, new Name("Bashar", "Khan"), new Address(),"bash@yahoo.com", Sex.MALE);
//        System.exit(0);

        List<Course> courseList = studentService.getCourseList();

        Filter<Course> courseFilter = new Filter<>();
        List<Course> filteredCourse = courseFilter.getSubSet(courseList, course -> course.getCourseCode().startsWith("CSE"));
        filteredCourse.forEach(System.out::println);

        long startTime, stopTime;

/*      //adding student
        for(int i = 1; i <= 100000; i++) {
            Student student = new Student(i,
                    new Name(generateRandomName(), generateRandomName()),
                    generateRandomEmailAddress(),
                    null,
                    Math.random() < 0.5 ? Sex.MALE : Sex.FEMALE);
            studentService.addStudent(student);
        }
*/
        startTime = System.currentTimeMillis();
        List<Student>studentList = studentService.getStudentList();
        stopTime = System.currentTimeMillis();
        System.out.printf("Time taken to fetch studentList : %.6f\n", (stopTime - startTime) / 1000.0);

        //female student
        startTime = System.currentTimeMillis();
        List<Student> femaleStudentList = studentList.
                parallelStream().
                filter(student -> student.getSex() == Sex.FEMALE).
                collect(Collectors.toList());

        System.out.println("Female Students : " + femaleStudentList.size());
        stopTime = System.currentTimeMillis();
        System.out.printf("Time taken : %.3f\n", (stopTime - startTime) / 1000.0);

        //male student
        startTime = System.currentTimeMillis();
        Filter<Student> filter = new Filter<>();
        List<Student> maleStudentList = filter.getSubSet(studentList, student -> student.getSex() == Sex.MALE);
//        List<Student> maleStudentList = Filter.getMaleStudents(studentList, Sex.MALE);
/*
        List<Student> maleStudentList = Filter.getSubSet(studentList, new TestInterface() {
            //Anonymous inner class
            @Override
            public boolean test(Student student) {
                return student.getSex() == Sex.MALE;
            }
        });
*/
/*
        List<Student> maleStudentList = studentList.
                parallelStream().
                filter(student -> student.getSex() == Sex.MALE).
                collect(Collectors.toList());
*/

/*
        for(Student student : studentList)
            if(student.getSex() == Sex.MALE)
                maleStudentList.add(student);
*/

        System.out.println("Male students : " + maleStudentList.size());
        stopTime = System.currentTimeMillis();
        System.out.printf("Time taken : %.3f\n", (stopTime - startTime) / 1000.0);

        System.out.println("Before sorting : ");
        for(int i = 0; i < 10; i++)
            System.out.println(maleStudentList.get(i));

        Collections.sort(maleStudentList, (s1,s2) -> s1.getName().firstName.compareTo(s2.getName().firstName));
//        Collections.sort(maleStudentList, new StudentComparatorBasedOnName());
        System.out.println("After sorting : ");
//        StudentService studentService = new StudentService();
        for(int i = 0; i < 10; i++)
            System.out.println(maleStudentList.get(i));
//        Student student = studentService.getStudent(1);
//        System.out.println(student);

//        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();

//        Student student1 = session.get(Student.class,1);
//        student1.setSex(Sex.MALE);
//        Student student2 = session.get(Student.class,2);
//        student2.setSex(Sex.FEMALE);

        // Registered course for student 2.
//        for(Course course : student.getCourseSet())
//            System.out.println(course);

//        Course course1 = session.get(Course.class,"ETE 2023");
//        Course course2 = session.get(Course.class,"ETE 2024");
//        student.getCourseSet().add(course1);
//        student.getCourseSet().add(course2);
//        session.save(student);

//        Query query = session.createQuery("from Course");
//        List<Course> courseList = query.getResultList();
//        courseList.forEach(System.out::println);

//        Course course = new Course();
//        course = session.get(Course.class,"ETE 2024");
//        course.setCreditHour(1.0);


//        session.save(new Course("CSE 3011", "Database Design", 3.0));
//        session.save(new Course("ETE 2024", "Communication Theory Lab", 1.0));


//        Student student = new Student(4,"Imran Khan");
//        student.setEmailAddress("imran_khan@ovi.com");
//        session.save(student);

//        session.getTransaction().commit();
        SessionFactorySingleton.getSessionFactory().close();
    }

    public static void main(String args[]) {
        new Main();
    }
}
