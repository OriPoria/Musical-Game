package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement; 

public class Database {

	public static void createTable() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement("CREATE TABLE scoretable(id int NOT NULL AUTO_INCREMENT, name varchar(255), score int, PRIMARY KEY(id))");
			create.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("Function complete");
		}
	}
	
	public static void post(String name, int score) {
		try {
			Connection conn = getConnection();
			PreparedStatement posted = conn.prepareStatement("INSERT INTO scoretable (name, score) VALUES ('"+name+"', '"+score+"')");
			posted.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Inserted completed");
		}
		
	}
	
	public static User get(String name) {
		try {
			Connection conn = getConnection();
			Statement st = conn.createStatement();
			String sql = ("SELECT * FROM scoretable WHERE name ='" +name +"';" );
			ResultSet rs = st.executeQuery(sql);
			rs.next(); // if not exists throws exception
			int id = rs.getInt("score"); 
			String str1 = rs.getString("name");
			User user = new User();
			user.setName(str1);
			user.setTopScore(id);
			return user;
			

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("name is not in the table");
			return null;

		} finally {
			System.out.println("Get user completed");
		}
	}
	
	
	 public static Connection getConnection() throws Exception{
	  try{
	   String driver = "com.mysql.jdbc.Driver";
	   String url = "jdbc:mysql://localhost:3306/testdb";
	   String username = "root";
	   String password = "ELal2427";
	   Class.forName(driver);
	   
	   Connection conn = DriverManager.getConnection(url,username,password);
	   System.out.println("Connected");
	   return conn;
	  } catch(Exception e){System.out.println(e);}
	  
	  
	  return null;
	 }
}
