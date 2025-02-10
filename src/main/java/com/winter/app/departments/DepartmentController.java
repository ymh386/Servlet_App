package com.winter.app.departments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.app.ActionForward;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DepartmentService departmentService;
	/*
	 * 서버 요청시
	 * 1. URL(ip:port/경로)
	 * 2. 메서드 형식
	 * 		1)GET 
	 * 			* 단순 요청 시
	 * 			* 파라미터가 주소창에 노출(파라미터가 Header에 담김)
	 * 			* 작은 용량을 보낼 때 사용
	 * 		2)POST
	 * 			* 보안이 요구 되는 요청시
	 * 			* 파라미터가 주소창에 노출이 되지 않음! => 파라미터가 Body에 담긴다.
	 * 			* 큰 용량을 보낼 대 사용
	 * 
	 * 3. 메서드 결정
	 * 		1) 주소창에 URL 직접 입력 => GET
	 * 		2) a 태그 사용 => GET
	 */

    /**
     * Default constructor. 
     */
    public DepartmentController() {
        // TODO Auto-generated constructor stub
		departmentService = new DepartmentService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
			//String method = request.getMethod();
			//StringBuffer url = request.getRequestURL();
			String uri = request.getRequestURI();
			
			uri = uri.substring(uri.lastIndexOf("/")+1);
			
			String path="";
			
			ActionForward actionForward = new ActionForward();
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/errors/notfound.jsp");
			try {
					switch(uri) {
					case "list.do":
						departmentService.getList(request, actionForward);
						//attribute : 속성 (키:String , 값:Object)
						//  
						break;
					
					case "detail.do":
						departmentService.getDetail(request, actionForward);
						
						break;
					
					case "add.do":
						String method = request.getMethod();
						if(method.toUpperCase().equals("POST")) {
							departmentService.add(request, actionForward);
						}else {
							actionForward.setFlag(true);
							actionForward.setPath("/WEB-INF/views/departments/add.jsp");
						}
						
						break;
						
					case "update.do":
						String m = request.getMethod();
						if(m.toUpperCase().equals("POST")) {
							departmentService.updateProcess(request, actionForward);
						} else {
							departmentService.update(request, actionForward);
						}
						
						break;
						
					case "delete.do":
						departmentService.delete(request, actionForward);
						break;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
			
//			try {
//			DepartmentDAO departmentDAO = new DepartmentDAO();
//			List<DepartmentDTO> ar = departmentDAO.getList();		
//			//attribute : 속성 (키:String , 값:Object)
//			//          
//			request.setAttribute("list", ar);
//			
//			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/departments/list.jsp");
//			view.forward(request, response);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
