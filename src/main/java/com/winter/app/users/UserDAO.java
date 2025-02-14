package com.winter.app.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.winter.app.utils.DBConnection;

public class UserDAO {
	
	public int join(UserDTO userDTO) throws Exception {
		int result = 0;
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, userDTO.getUserName());
		st.setString(2, userDTO.getPassword());
		st.setString(3, userDTO.getName());
		st.setString(4, userDTO.getPhone());
		st.setString(5, userDTO.getEmail());
		
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
	}
	
	public UserDTO login(UserDTO userDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, userDTO.getUserName());
		st.setString(2, userDTO.getPassword());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			userDTO.setName(rs.getString("NAME"));
			userDTO.setPhone(rs.getString("PHONE"));
			userDTO.setEmail(rs.getString("EMAIL"));
		}else {
			userDTO = null;
		}
		
		DBConnection.disConnect(rs, st, con);
		
		
		return userDTO;
	}
	
	public int update(UserDTO userDTO) throws Exception {
		int result = 0;
		Connection con = DBConnection.getConnection();
		String sql="UPDATE USERS SET PASSWORD=?, NAME=?, PHONE=?, EMAIL=? WHERE USERNAME=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, userDTO.getPassword());
		st.setString(2, userDTO.getName());
		st.setString(3, userDTO.getPhone());
		st.setString(4, userDTO.getEmail());
		st.setString(5, userDTO.getUserName());
		
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
	}

}
