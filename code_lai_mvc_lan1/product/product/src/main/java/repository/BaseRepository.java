package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String URL="jdbc:mysql://localhost:3306/product";
    private static final String USER="root";
    private static final String PASS="tonyadam56";

    public static Connection getConnectDB(){
      Connection connection = null ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(URL,USER,PASS);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return  connection;
    }










}



