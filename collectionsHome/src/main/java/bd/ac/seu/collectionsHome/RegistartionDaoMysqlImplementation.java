package bd.ac.seu.collectionsHome;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegistartionDaoMysqlImplementation implements RegistartionDao {
    @Override
    public List<Registartion> getRegisteredStudent() throws SQLException {
        List<Registartion> registartionList;
        registartionList = new ArrayList<>();
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
        String query = "select * from registration";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int studentId = resultSet.getInt("studentId");
            String courseCode = resultSet.getString("courseCode");
            String facultyInitials = resultSet.getString("facultyInitials");
            int semesterId = resultSet.getInt("semesterId");

            Registartion registartion = new Registartion(studentId, courseCode,
                                                        facultyInitials,
                                                        semesterId);
            registartionList.add(registartion);
        }
        return registartionList;
    }
}
