package bd.ac.seu.collectionsHome;


import java.sql.SQLException;
import java.util.List;

public interface GradeRecordDao {
    public List<GradeRecord> getGradeRecord() throws SQLException;
}
