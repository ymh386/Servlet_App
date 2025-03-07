package com.winter.app.employees;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.winter.app.ActionForward;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        employeeService = new EmployeeService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/") + 1);
		String path = "";
		
		ActionForward actionForward = new ActionForward();
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/errors/notfound.jsp");
		
		try {
			switch(uri) {
			case "join.do":
				String method = request.getMethod();
				if(method.toUpperCase().equals("POST")) {
					employeeService.join(request, actionForward);
				}else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/employees/join.jsp");
				}
				
				break;
				
			case "login.do":
				String m = request.getMethod();
				
				//cookie 꺼내기
				Cookie [] cookies  = request.getCookies();
				
				for(Cookie cookie:cookies) {
					System.out.println(cookie.getName());
					System.out.println(cookie.getValue());
				}
				
				if(m.toUpperCase().equals("POST")) {
					employeeService.login(request, actionForward);
				}else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/employees/login.jsp");
				}
				break;
				
			case "logout.do":
				HttpSession session = request.getSession();
				//session.setAttribute("user", null);
				//session.removeAttribute("user");
				//session.removeValue("user");
				session.invalidate();
				
				actionForward.setFlag(false);
				actionForward.setPath("../index.do");
				
				break;
				
			case "mypage.do":
				employeeService.detail(request, actionForward);
				
				actionForward.setFlag(true);
				actionForward.setPath("/WEB-INF/views/employees/mypage.jsp");
				
				break;
			
			case "update.do":
				String mm = request.getMethod();
				if(mm.toUpperCase().equals("POST")) {
					employeeService.update(request, actionForward);
				}else {
					employeeService.detail(request, actionForward);
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/employees/update.jsp");
				}
				
				break;
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(actionForward.isFlag()) {
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
		}else {
			//redirect
			response.sendRedirect(actionForward.getPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
