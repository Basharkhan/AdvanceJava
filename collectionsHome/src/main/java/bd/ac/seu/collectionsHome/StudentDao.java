package bd.ac.seu.collectionsHome;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    public void updateStudent(int id, String name);
    public List<Student> getAllStudents() throws SQLException;
    public void addStudent(int studentId, String studentName) throws SQLException;
    public default Student getStudent(int studentId) throws SQLException {
        List<Student> studentList;
        studentList = getAllStudents();
        for(Student student : studentList)
            if(student.getStudentId() == studentId)
                return student;
        return null;

    }
    public boolean deleteStudent(int studentId) throws SQLException;
}
