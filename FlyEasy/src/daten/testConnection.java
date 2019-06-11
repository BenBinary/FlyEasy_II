package daten;


import java.sql.*;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import fachlogik.Destinations;
import fachlogik.Flug;

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
			lport  = 4322;
			
			// ESTABLISHING THE REMOTE CONNECTION
			
			session.setPassword(password);
			session.setConfig("StrictHostKeyChecking", "no");
			
			
			session.connect();
			
			System.out.println(session.getHost());
			
			System.out.println(session.isConnected());
			
			//int assinged_port = session.setPortForwardingL(lport, rhost, rport);
			//System.out.println("localhost:"+assinged_port+" -> "+rhost+":"+rport);
			 
		} catch (Exception e) {
			System.err.print(e);
		}
		
	}
	
	
	public static Boolean saveFlights(List<Flug> fluege) {
		
		// Aufbau der SSH-Verbindung
		try {
			
			go();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Connection con = DriverManager.getConnection("87.190.44.81:22", "Fly", "easy");
		Connection con = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String db = "FlyEasy";
		String dbUser = "Fly";
		String dbPasswd = "easy";
		String url = "jdbc:mysql://" + rhost + ":" + lport + "/";
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url+db, dbUser, dbPasswd);
			
			
			try {
				Statement st = con.createStatement();
				String sql = "Select * from Flights";
				
				String insert_string = "";
				int pk = 1;
				
				for (Flug flug : fluege) {
					
					insert_string += MessageFormat.format("INSERT INTO `FlyEasy`.`Flights` (`idFlights`, `src`, `dst`, `datum`) VALUES ('{0}', '{1}', '{2}', '{3}');\n", pk, flug.getOrigin().toString(), flug.getDestination().toString(), flug.getStartDatumString());
					pk++;
				}
				
				st.executeQuery(insert_string);
				
				
				
			} catch (SQLException s) {
				
				System.out.println("SQL statement is not executed");
				
			}
			
			
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		return true;
		
	}
	
	
	public static LinkedList<Flug> loadFlights() {
		  
		LinkedList<Flug> fluege = new LinkedList<>();
		  

		// Aufbau der SSH-Verbindung
		try {
			
			go();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Connection con = DriverManager.getConnection("87.190.44.81:22", "Fly", "easy");
		Connection con = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String db = "FlyEasy";
		String dbUser = "Fly";
		String dbPasswd = "easy";
		String url = "jdbc:mysql://" + rhost + ":" + lport + "/";
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url+db, dbUser, dbPasswd);
			
			
			try {
				Statement st = con.createStatement();
				String sql = "Select * from Flights";
				
				
				ResultSet rs = st.executeQuery(sql);
				
				
				while (rs.next()) {
					
					Flug flug = new Flug();
				
					flug.setOrigin(rs.getString(2));
					flug.setDestination(rs.getString(3));
					flug.setStartDatumString(rs.getString(4));
					
					System.out.println(rs.getString(3));
					
					
					fluege.add(flug);
				}
				
				
				
				
				
			} catch (SQLException s) {
				
				System.out.println("SQL statement is not executed");
				
			}
			
			
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
		return fluege;	  
		  
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
		
		String db = "FlyEasy";
		String dbUser = "Fly";
		String dbPasswd = "easy";
		String url = "jdbc:mysql://" + rhost + ":" + lport + "/";
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url+db, dbUser, dbPasswd);
			
			
			try {
				Statement st = con.createStatement();
				String sql = "Select * from Flights";
				
				
				ResultSet rs = st.executeQuery(sql);
				
				
				while (rs.next()) {
				
					System.out.println(rs.getString(3));
				}
				
				
				
				
				
			} catch (SQLException s) {
				
				System.out.println("SQL statement is not executed");
				
			}
			
			
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
