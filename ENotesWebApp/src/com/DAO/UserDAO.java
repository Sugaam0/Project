package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.User.UserDetails;

public class UserDAO {
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser(UserDetails us) {
		boolean f = false;

		try {
			String query = "insert into user(Name,Email,password,contact) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPass());
			ps.setString(4, us.getContact());

			int i = ps.executeUpdate();
			if (i == 1) {
				
				f = true;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public UserDetails login(UserDetails us) {
		UserDetails user=null;
		try {

			String query = "select * from user where Email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, us.getEmail());
			ps.setString(2, us.getPass());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				user = new UserDetails();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("Name"));
				user.setEmail(rs.getString("Email"));
				user.setPass(rs.getString("password"));
				user.setContact(rs.getString("contact"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	
	}

	
}
