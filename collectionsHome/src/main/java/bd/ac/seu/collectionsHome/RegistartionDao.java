package bd.ac.seu.collectionsHome;

import java.sql.SQLException;
import java.util.List;

public interface RegistartionDao {
    public List<Registartion> getRegisteredStudent() throws SQLException;
}
