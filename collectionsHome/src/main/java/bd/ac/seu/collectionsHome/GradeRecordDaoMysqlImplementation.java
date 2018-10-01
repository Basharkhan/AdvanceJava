package bd.ac.seu.collectionsHome;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GradeRecordDaoMysqlImplementation implements GradeRecordDao {
    @Override
    public List<GradeRecord> getGradeRecord() throws SQLException {
        List<GradeRecord> gradeRecordList;
        gradeRecordList = new ArrayList<>();
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
        String query = "select * from grades";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int studentId = resultSet.getInt("studentId");
            String courseCode = resultSet.getString("courseCode");
            String facultyInitials = resultSet.getString("facultyInitials");
            String grade = resultSet.getString("grade");
            int semesterId = resultSet.getInt("semesterId");

            GradeRecord gradeRecord = new GradeRecord(studentId, courseCode,
                                                      facultyInitials,
                                                      grade,
                                                      semesterId);
            gradeRecordList.add(gradeRecord);
        }
        return gradeRecordList;
    }
}
