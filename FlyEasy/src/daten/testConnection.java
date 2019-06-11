package daten;


import java.sql.*;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class testConnection {
	
	
	static int lport;
	static String rhost;
	static int rport;
	
	
	public static void go() {
		
		String user = "swt";
		String password = "tws";
		String host = "87.190.44.81";
		int port = 22;
		
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, port);

			
			// EINSTELLUNGEN FÜR DIE DB

			rhost = "127.0.0.1";
			rport = 3000;
			lport  = 4321;
			
			// ESTABLISHING THE REMOTE CONNECTION
			
			session.setPassword(password);
			session.setConfig("StrictHostKeyChecking", "no");
			
			
			session.connect();
			
			System.out.println(session.getHost());
			
			System.out.println(session.isConnected());
			
			int assinged_port = session.setPortForwardingL(lport, rhost, rport);
			System.out.println("localhost:"+assinged_port+" -> "+rhost+":"+rport);
			 
		} catch (Exception e) {
			System.err.print(e);
		}
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			go();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Connection con = DriverManager.getConnection("87.190.44.81:22", "Fly", "easy");
		Connection con = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://" + rhost + ":" + lport + "/";
		String db = "FlyEasy";
		String dbUser = "Fly";
		String dbPasswd = "easy";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url+db, dbUser, dbPasswd);
			
			/*
			try {
			//	Statement st = con.createStatement();
			//	String sql = "Select * from Flights";
				
				
				//ResultSet rs = st.executeQuery(sql);
				//System.out.println(rs.toString());
				
			} catch (SQLException s) {
				
				System.out.println("SQL statement is not executed");
				
			}
			
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
