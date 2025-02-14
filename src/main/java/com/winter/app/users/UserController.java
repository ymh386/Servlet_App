package com.winter.app.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.winter.app.ActionForward;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        userService = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/") + 1);
		
		String path = "";
		
		ActionForward actionForward = new ActionForward();
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/errors/error.jsp");
		
		try {
			if(uri.equals("join.do")) {
				String method = request.getMethod();
				if(method.toUpperCase().equals("POST")) {
					userService.join(request, actionForward);
				}else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/users/join.jsp");
				}
			}else if(uri.equals("login.do")) {
				String method = request.getMethod();
				if(method.toUpperCase().equals("POST")) {
					userService.login(request, actionForward);
				}else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/users/login.jsp");
				}
			}else if(uri.equals("logout.do")) {
				HttpSession session = request.getSession();
				session.invalidate();
				
				actionForward.setFlag(false);
				actionForward.setPath("../index.do");
			}else if(uri.equals("mypage.do")) {
				actionForward.setFlag(true);
				actionForward.setPath("/WEB-INF/views/users/mypage.jsp");
			}else if(uri.equals("update.do")) {
				String method = request.getMethod();
				if(method.toUpperCase().equals("POST")) {
					userService.update(request, actionForward);
				}else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/users/update.jsp");
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(actionForward.isFlag()) {
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
		}else {
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
