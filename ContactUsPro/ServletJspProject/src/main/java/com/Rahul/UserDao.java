package com.Rahul;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class UserDao {
	String url="jdbc:mysql://localhost:3306/admin";
	String username="root";
	String password="rahul";
	String query="SELECT * FROM user";
	public boolean isValidUser(User user) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con=DriverManager.getConnection(url,username,password);
		java.sql.PreparedStatement st=con.prepareStatement(query);
		java.sql.ResultSet rs=st.executeQuery();
		while(rs.next()) {
			if((rs.getString("name")).equals(user.getUser()) && (rs.getString("password")).equals(user.getPass())){
				return true;
			}
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return false;
	}
	
}

