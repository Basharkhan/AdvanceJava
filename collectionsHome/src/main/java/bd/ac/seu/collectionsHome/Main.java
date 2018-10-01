package bd.ac.seu.collectionsHome;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Student> studentList;
    List<Course> courseList;
    List<Registartion> registartionList;
    List<GradeRecord> gradeRecordList;

    public Main() throws SQLException {
        registartionList = new ArrayList<>();
        gradeRecordList = new ArrayList<>();
        //courseList = new ArrayList<>();
        //get all students
        StudentDao studentDao = new StudentDaoMysqlImplementation();
        studentList = studentDao.getAllStudents();
        studentList.forEach(System.out::println);
        System.out.println(studentDao.getStudent(26626));
        studentDao.updateStudent(1, "fag");
//        StudentDao studentDao = new StudentDaoTextFileImplementation();
        //add student
        studentDao.addStudent(15002, "June");
        studentList = studentDao.getAllStudents();
        studentList.forEach(System.out::println);
//        studentDao.deleteStudent(10004);
//        Student student = studentDao.getStudent(10004);
//        System.out.println("Student : " + student);

/*
        RegistartionDao registartionDao = new RegistartionDaoMysqlImplementation();
        registartionList = registartionDao.getRegisteredStudent();
*/
        //registartionList.forEach(System.out::println);

//        GradeRecordDao gradeRecordDao = new GradeRecordDaoMysqlImplementation();
//        gradeRecordList = gradeRecordDao.getGradeRecord();
//        gradeRecordList.forEach(System.out::println);
//        CourseDao courseDao = new CourseDaoMysqlImplementation();
//        courseList = courseDao.getAllCourse();
//        courseList.forEach(System.out::println);

//        Grade grade = Grade.A_PLUS;
//        System.out.println(grade.getNumericGrade());


/*      //student of maximum length
        Student maxLengthStudent = studentList.get(0);

        for(Student student : studentList) {
            if(student.getStudentName().length() > maxLengthStudent.getStudentName().length())
                maxLengthStudent = student;
        }
        System.out.println("Max Length Student : " + maxLengthStudent);
*/

    }

    public static void main(String args[]) throws SQLException {
        new Main();
    }
}
