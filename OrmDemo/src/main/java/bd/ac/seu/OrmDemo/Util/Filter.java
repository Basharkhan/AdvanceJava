package bd.ac.seu.OrmDemo.Util;

import bd.ac.seu.OrmDemo.Course;
import bd.ac.seu.OrmDemo.Sex;
import bd.ac.seu.OrmDemo.Student;

import java.util.ArrayList;
import java.util.List;

public class Filter<T> {
    public List<T> getSubSet(List<T> list, TestInterface<T> testInterface) {
        List<T> newList = new ArrayList<>();
        for(T t : list)
            if(testInterface.test(t))
                newList.add(t);
        return newList;
    }
/*
    public static List<Student> getSubSet(List<Student> studentList, TestInterface testInterface) {
        List<Student> newStudentList = new ArrayList<>();
        for(Student student : studentList) {
            if (testInterface.test(student))
                newStudentList.add(student);
        }
        return newStudentList;
    }
*/

    public static List<Student> getMaleStudents(List<Student> studentList, Sex sex) {
        List<Student> newStudentList = new ArrayList<>();
        for(Student student : studentList)
            if(student.getSex() == Sex.MALE)
                newStudentList.add(student);
        return newStudentList;
    }

    public static List<Course> getSubCourse(List<Course> courseList, String prefix) {
        List<Course> filteredCourse = new ArrayList<>();
        for(Course course : courseList) {
            if(course.getCourseCode().startsWith(prefix))
                filteredCourse.add(course);
        }
        return filteredCourse;
    }
}
