package daten;


import java.sql.*;

public class testConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection con = DriverManager.getConnection("87.190.44.81:22", "Fly", "easy");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
