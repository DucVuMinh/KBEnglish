package hust.kb.kbenglish.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDBService {
	public static String DATABASE = "jdbc:mariadb://localhost:3306/KBEnglish";
	public static String USER_NAME = "root";
	public static String PASSWORD = "";
	public static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if (connection == null )
			connection = DriverManager.getConnection(DATABASE, USER_NAME, PASSWORD);
		return connection;
	}
}
