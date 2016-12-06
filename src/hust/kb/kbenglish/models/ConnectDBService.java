package hust.kb.kbenglish.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDBService {
	public static String DATABASE = "jdbc:mariadb://localhost:6688/knowledgebasedsystem";
	public static String USER_NAME = "root";
	public static String PASSWORD = "1234567";
	public static Connection connection;
	
	public static Connection getConnection() {
            try{
		if (connection == null )
			connection = DriverManager.getConnection(DATABASE, USER_NAME, PASSWORD);
            }catch(SQLException ex){
                ex.printStackTrace();
            }
		return connection;
	}
        public static void main(String args[]){
            try {
                getConnection();
            } catch (Exception ex) {
                Logger.getLogger(ConnectDBService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
