package com.winter.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.utils.DBConnection;

public class DepartmentDAO {
	
	public List<DepartmentDTO> getList()throws Exception{
		//DB에서 부서 리스트를 조회
		//1. Connection 
		Connection con = DBConnection.getConnection();
		//2. sql
		String sql = "SELECT * FROM DEPARTMENTS";
		//3. 미리보내기
		PreparedStatement st = con.prepareStatement(sql);
		//4. ? 처리하기
		//5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		List<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			
			ar.add(departmentDTO);
		}
		//6. 연결 해제
		DBConnection.disConnect(rs, st, con);
		
		return ar;
	}
	
	//한 부서의 모든 정보
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception {
		//DB에서 하나의 부서 정보를 조회
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM WHERE DEPARTMENT_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
		} else {
			departmentDTO = null;
		}
		DBConnection.disConnect(rs, st, con);
		return departmentDTO;
	}

}
