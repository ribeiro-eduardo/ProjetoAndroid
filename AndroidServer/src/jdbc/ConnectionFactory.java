package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eduardo Ribeiro
 */
public class ConnectionFactory {
    public static Connection getConnection() throws SQLException{
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return DriverManager.getConnection("jdbc:mysql://localhost/android", "root", "travessa05");

    }
}
