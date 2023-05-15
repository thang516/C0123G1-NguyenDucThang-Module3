package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {

    public static final String URL = "jdbc:mysql://localhost:3306/hop_dong";
    public static final String USER = "root";
    public static final String PASS = "tonyadam56";
    public static Connection getConnectDB(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  connection;
    }
}
