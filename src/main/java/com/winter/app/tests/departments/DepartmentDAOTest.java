package com.winter.app.tests.departments;

import java.util.List;

import com.winter.app.departments.DepartmentDAO;
import com.winter.app.departments.DepartmentDTO;

public class DepartmentDAOTest {
	
	public static void main(String[] args) {
		
		DepartmentDAO dao = new DepartmentDAO();
		try {
			List<DepartmentDTO> dtos = dao.getList();
			System.out.println(dtos.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
