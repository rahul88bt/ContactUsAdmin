package com.Rahul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class RequestDao {
	String insert="INSERT INTO details (name,email,message) VALUES(?,?,?)";
	String activeQuery="SELECT * FROM details WHERE status=?";
	String archiveQuery="SELECT * FROM details WHERE status=?";
	String statusQuery="UPDATE details set status= NOT status WHERE id=?";
	
	String url="jdbc:mysql://localhost:3306/contactus";
	String username="root";
	String password="rahul";
	public void insertData(Request r) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement(insert);
			st.setString(1, r.getName());
			st.setString(2, r.getEmail());
			st.setString(3, r.getMessage());
			int res=st.executeUpdate();
			if(res==1) {
				System.out.println("Data Added");
			}
			else {
				System.out.println("Not Added");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Request> fetchActiveUser(boolean status) {
		ArrayList<Request> activeUser=new ArrayList<>();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement st=con.prepareStatement(activeQuery);
		st.setBoolean(1, status);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			Request r=new Request();
			r.setId(rs.getInt("id"));
			r.setName(rs.getString("name"));
			r.setEmail(rs.getString("email"));
			r.setMessage(rs.getString("message"));
			activeUser.add(r);
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return activeUser;
	}
	
	public ArrayList<Request> fetchArchiveUser(boolean status) {
		ArrayList<Request> archiveUser=new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement(archiveQuery);
			st.setBoolean(1, status);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Request r=new Request();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
				r.setEmail(rs.getString("email"));
				r.setMessage(rs.getString("message"));
				archiveUser.add(r);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return archiveUser;
	}
	
	public void changeStatus(int id,boolean status) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement(statusQuery);
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
