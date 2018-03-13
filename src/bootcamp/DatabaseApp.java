package bootcamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseApp {
	
	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root",null)){
			
			PreparedStatement prep = conn.prepareStatement("insert into first_table (id,name,age) values (?,?,?)");
			
			prep.setObject(1, null);
			prep.setString(2, "Agus");
			prep.setInt(3, 32);
			prep.addBatch();
			
			prep.setObject(1, null);
			prep.setString(2, "Budi");
			prep.setInt(3, 30);
			prep.addBatch();
			
			prep.executeBatch();
			
			ResultSet result = conn.createStatement().executeQuery("select * from first_table");
			
			while(result.next()) {
				System.out.println("ID "+result.getInt(1)+" Name "+result.getString(2)+" Age "+result.getInt(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
