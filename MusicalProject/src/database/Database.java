package database;
import java.sql.Connection;
import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement; 

public class Database {

	public static void createTable() {
		try {
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement("CREATE TABLE scoretable(id int NOT NULL AUTO_INCREMENT, name varchar(255), score int, PRIMARY KEY(id))");
			create.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println("Couldn't create table");
		} finally {
			System.out.println("Function complete");
		}
	}
	
	public static void post(String name, int score) {
		try {
			Connection conn = getConnection();
			PreparedStatement posted = conn.prepareStatement("INSERT INTO scoretable (name, score) VALUES ('"+name+"', '"+score+"')");
			posted.executeUpdate();
			conn.close();
			
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
			conn.close();
			return user;
			

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Name is not in the table");
			return null;

		} finally {
			System.out.println("Get user completed");
		}
	}
	
	
	 public static Connection getConnection() throws Exception{
		 String currentPath = new java.io.File(".").getCanonicalPath();
		 File secrectData = new File("src/database/dbdetails.txt");
		 boolean b = secrectData.exists();
		 Scanner myReader = new Scanner(secrectData);
	      String[] lines = new String[4];
	      int i = 0;
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        System.out.println(data);
	        lines[i] = data;
	        i++;
	      }
	      myReader.close();		 
	   String driver = lines[0];
	   String url = lines[1];
	   String username = lines[2];
	   String password = lines[3];
	   Class.forName(driver);
	   
	   Connection conn = DriverManager.getConnection(url,username,password);
	   System.out.println("Connected");
	   return conn;
	  
	  
	 }
}
