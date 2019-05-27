package daten;

import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.sql.DataSource;





public class db_connection {

	
	
	public static void main(String[] args) {
	
		try {
				Connection con;
				// jdbc:mysql://
				
				
				con = DriverManager.getConnection("localhost:3306/flyeasy", "swt", "2019");
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery("Select * from fluege;");
						
				while (rs.next()) {
	
					System.out.println(rs);
					
				}
				
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	
	}
}
