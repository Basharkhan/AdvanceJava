package bd.ac.seu.collectionsHome;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoMysqlImplementation implements CourseDao {
    List<Course> courseList;
    @Override
    public List<Course> getAllCourse() throws SQLException {
        courseList = new ArrayList<>();
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
        String query = "select * from course";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String courseCode = resultSet.getString("courseCode");
            String courseTitle = resultSet.getString("courseTitle");
            double credits = resultSet.getDouble("credits");
            Course course = new Course(courseCode,
                                       courseTitle,
                                        credits);
            courseList.add(course);
        }
        return courseList;
    }
}
