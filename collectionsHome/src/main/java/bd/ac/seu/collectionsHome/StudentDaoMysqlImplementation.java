package bd.ac.seu.collectionsHome;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoMysqlImplementation implements StudentDao {
    List<Student> studentList;


    @Override
    public void updateStudent(int id, String name) {
        Connection connection = JdbcConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "update student set studentId = '"+id+"', studentName = '"+name+"' where studentId = '"+id+"'";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
        String query = "select * from student";
        ResultSet resultSet = statement.executeQuery(query);
        studentList = new ArrayList<>();

        while (resultSet.next()) {
            int studentId = resultSet.getInt("studentId");
            String studentName = resultSet.getString("studentName");
            Student student = new Student(studentId, studentName);
            studentList.add(student);
        }
        return studentList;
    }
    @Override
    public Student getStudent(int studentId) {
        Student student = null;

        try {
            Connection connection = JdbcConnection.getConnection();

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM student WHERE studentId = " + studentId;
            ResultSet resultSet = statement.executeQuery(query);
            studentList = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("studentId");
                String name = resultSet.getString("studentName");
                student = new Student(id, name);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }


    @Override
    public void addStudent(int studentId, String studentName) throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
        String query = "insert into student values('"+studentId+"', '"+studentName+"')";
        statement.executeUpdate(query);
    }

    @Override
    public boolean deleteStudent(int studentId) throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();

        String query;
        query = "delete from registration where studentId = " + studentId;
        statement.executeUpdate(query);
        query = "delete from grades where studentId = " + studentId;
        statement.executeUpdate(query);
        query = "delete from student where studentId = " + studentId;
        statement.executeUpdate(query);
        int x = statement.executeUpdate(query);

        if(x > 0)
            return true;
        return false;
    }

}
