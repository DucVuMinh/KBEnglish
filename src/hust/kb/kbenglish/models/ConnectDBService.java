package hust.kb.kbenglish.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDBService {
	public static Connection connection;
	
	public static Connection getConnection() {
            try{
		if (connection == null )
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/knowledgebasedsystem", Config.USER_NAME, Config.PASSWORD);
            }catch(SQLException ex){
                ex.printStackTrace();
            }
		return connection;
	}
	
	public static Statement getStatement() throws SQLException {
		return getConnection().createStatement();
	}
        public static void main(String args[]){
            try {
                getConnection();
            } catch (Exception ex) {
                Logger.getLogger(ConnectDBService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
