package com.winter.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.winter.app.utils.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class EmployeeDAO {
	
	public int update(EmployeeDTO employeeDTO) throws Exception {
		int result = 0;
		Connection con = DBConnection.getConnection();
		String sql = "UPDATE EMPLOYEES SET FIRST_NAME=?, LAST_NAME=?"
				+ " WHERE EMPLOYEE_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, employeeDTO.getFirst_name());
		st.setString(2, employeeDTO.getLast_name());
		st.setInt(3, employeeDTO.getEmployee_id());
		
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
	}
	
	public EmployeeDTO detail(EmployeeDTO employeeDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, employeeDTO.getEmployee_id());
		
		ResultSet rs = st.executeQuery();
		EmployeeDTO result = null;
		if(rs.next()) {
			result = new EmployeeDTO();
			result.setLast_name(rs.getString("LAST_NAME"));
			result.setEmail(rs.getString("EMAIL"));
			result.setPhone_number(rs.getString("PHONE_NUMBER"));
			result.setJob_id(rs.getString("JOB_ID"));
			result.setSalary(rs.getInt("SALARY"));
			result.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			result.setManager_id(rs.getInt("MANAGER_ID"));
			result.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			result.setPassword(rs.getString("PASSWORD"));
		}
		
		DBConnection.disConnect(rs, st, con);
		
		return result;
	}
	
	public EmployeeDTO login(EmployeeDTO employeeDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT EMPLOYEE_ID, PASSWORD, FIRST_NAME FROM EMPLOYEES"
				+ " WHERE EMPLOYEE_ID = ? AND PASSWORD = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, employeeDTO.getEmployee_id());
		st.setString(2, employeeDTO.getPassword());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
		}else {
			employeeDTO = null;
		}
		
		DBConnection.disConnect(rs, st, con);
		
		return employeeDTO;
	}
	
	public int join(EmployeeDTO employeeDTO) throws Exception {
		int result = 0;
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO EMPLOYEES"
				+ " VALUES (EMPLOYEES_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, employeeDTO.getFirst_name());
		st.setString(2, employeeDTO.getLast_name());
		st.setString(3, employeeDTO.getEmail());
		st.setString(4, employeeDTO.getPhone_number());
		st.setString(5, employeeDTO.getJob_id());
		st.setInt(6, employeeDTO.getSalary());
		st.setDouble(7, employeeDTO.getCommission_pct());
		st.setInt(8, employeeDTO.getManager_id());
		st.setInt(9, employeeDTO.getDepartment_id());
		st.setString(10,  employeeDTO.getPassword());
		
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
	}

}
