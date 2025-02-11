package com.winter.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.winter.app.utils.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class EmployeeDAO {
	
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
