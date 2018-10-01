package bd.ac.seu.collectionsHome;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    List<Course> getAllCourse() throws SQLException;
}
