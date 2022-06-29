package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
  /*use below method for your database connection for mysql*/
  /*do not edit the below method, you must use only this one for your database connection*/
  public Connection getConnection()throws Exception {
	  
	  String url = "jdbc:mysql://"+serverName+":"+portNumber+"/"+dbName;
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  return DriverManager.getConnection(url, userID, password);
  }

  /*Insert your other code right after this comment*/
  /*Change/update information of your database connection, do not change name of instance variable in this class*/
  private final String serverName = "localhost";
  private final String dbName = "shoppingdb";
  private final String portNumber = "3306";
  private final String userID = "miraclelife1412";
  private final String password = "MLuNXuMjD123";
  
  public static void main (String[] args) {
	  try {
		  DBContext db = new DBContext();
		  Connection conn = db.getConnection();
		  System.out.print("success");
  } catch (Exception e) {
	  System.out.print(e.getMessage());
  }
 }
}