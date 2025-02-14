package com.winter.app.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.winter.app.ActionForward;

public class UserService {
	
	private UserDAO userDAO;
	
	public UserService() {
		// TODO Auto-generated constructor stub
		userDAO = new UserDAO();
	}
	
	public void update(HttpServletRequest request, ActionForward actionForward) throws Exception {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(request.getParameter("userName"));
		userDTO.setPassword(request.getParameter("password"));
		userDTO.setName(request.getParameter("name"));
		userDTO.setPhone(request.getParameter("phone"));
		userDTO.setEmail(request.getParameter("eamil"));
		
		int result = userDAO.update(userDTO);
		
		actionForward.setFlag(false);
		actionForward.setPath("./mypage.do");
	}
	
	public void login(HttpServletRequest request, ActionForward actionForward) throws Exception {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(request.getParameter("userName"));
		userDTO.setPassword(request.getParameter("password"));
		userDTO = userDAO.login(userDTO);
		
		if(userDTO != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("user", userDTO);
			actionForward.setFlag(false);
			actionForward.setPath("../index.do");
		}else {
			request.setAttribute("result", "로그인 실패");
			request.setAttribute("path", "./login.do");
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		}
		
	}
	
	public void join(HttpServletRequest request, ActionForward actionForward) throws Exception {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(request.getParameter("userName"));
		userDTO.setPassword(request.getParameter("password"));
		userDTO.setName(request.getParameter("name"));
		userDTO.setPhone(request.getParameter("phone"));
		userDTO.setEmail(request.getParameter("email"));
		
		int result = userDAO.join(userDTO);
		
		String str = "회원가입 실패";
		if(result > 0) {
			str = "회원가입 성공";
		}
		
		request.setAttribute("result", str);
		request.setAttribute("path", "../index.do");
		
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
	}

}
