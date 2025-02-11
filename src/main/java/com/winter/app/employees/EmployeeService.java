package com.winter.app.employees;

import javax.servlet.http.HttpServletRequest;

import com.winter.app.ActionForward;

public class EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeService() {
		// TODO Auto-generated constructor stub
		employeeDAO = new EmployeeDAO();
	}
	
	public void login(HttpServletRequest request, ActionForward actionForward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
		employeeDTO.setPassword(request.getParameter("password"));
		employeeDTO = employeeDAO.login(employeeDTO);
		
		if(employeeDTO != null) {
			//index
		}else {
			//
			request.setAttribute("result", "로그인 실패");
			request.setAttribute("path", "./login.do");
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		}
	}
	
	public void join(HttpServletRequest request, ActionForward actionForward) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setFirst_name(request.getParameter("first_name"));
		employeeDTO.setLast_name(request.getParameter("last_name"));
		employeeDTO.setEmail(request.getParameter("email"));
		employeeDTO.setPhone_number(request.getParameter("phone_number"));
		employeeDTO.setJob_id(request.getParameter("job_id"));
		employeeDTO.setSalary(Integer.parseInt(request.getParameter("salary")));
		employeeDTO.setCommission_pct(Double.parseDouble(request.getParameter("commission_pct")));
		employeeDTO.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
		employeeDTO.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
		employeeDTO.setPassword(request.getParameter("password"));
		
		int result = employeeDAO.join(employeeDTO);
		
		//redirect 방식
//		actionForward.setFlag(false);
//		actionForward.setPath("../index.do");
		
		String str = "사원 등록 실패";
		if(result > 0) {
			str = "사원 등록 성공";
		}
		
		request.setAttribute("result", str);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
	}

}
