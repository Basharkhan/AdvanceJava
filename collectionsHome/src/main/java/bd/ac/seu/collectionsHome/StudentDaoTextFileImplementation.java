package bd.ac.seu.collectionsHome;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoTextFileImplementation implements StudentDao {
    List<Student> studentList;
    @Override
    public List<Student> getAllStudents() throws SQLException {
        studentList = new ArrayList<>();
        try {
            RandomAccessFile input = new RandomAccessFile("student.txt", "r");
            String line = input.readLine();

            while ((line = input.readLine()) != null) {
                int comaIndex = line.indexOf(",");
                String id = line.substring(0, comaIndex);
                String name = line.substring(comaIndex + 2, line.length() - 1);
                Student student = new Student(Integer.parseInt(id), name);
                studentList.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void addStudent(int studentId, String studentName) throws SQLException {

    }


    @Override
    public boolean deleteStudent(int studentId) {

        for(int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getStudentId() == studentId) {
                studentList.remove(i);
            }
        }
        try {
            RandomAccessFile output = new RandomAccessFile("student.txt", "rw");
            output.setLength(0);
            for(Student student : studentList) {
                String line = String.format("%d, \"%s\"\n", student.getStudentId(), student.getStudentName());
                output.writeBytes(line);
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }
}
