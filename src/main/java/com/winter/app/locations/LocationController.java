package com.winter.app.locations;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.app.ActionForward;

/**
 * Servlet implementation class LocationController
 */
@WebServlet("/LocationController")
public class LocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocationService locationService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationController() {
        locationService = new LocationService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		
		
		uri = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(uri);
		
		String path = "";
		
		ActionForward actionForward = new ActionForward();
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/errors/notfound.jsp");
		
		try {
			switch(uri) {
			case "list.do":
				locationService.getList(request, actionForward);
				//attribute : 속성 (키:String , 값:Object)
				//  
				break;
			
			case "detail.do":
				locationService.getDetail(request, actionForward);
				
				break;
			
			case "add.do":
				String method = request.getMethod();
				if(method.toUpperCase().equals("POST")) {
					locationService.add(request, actionForward);
				}else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/locations/add.jsp");
				}
				
				break;
				
			case "update.do":
				String m = request.getMethod();
				if(m.toUpperCase().equals("POST")) {
					locationService.updateProcess(request, actionForward);
				} else {
					locationService.update(request, actionForward);
				}
				
				break;
				
			case "delete.do":
				locationService.delete(request, actionForward);
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
		view.forward(request, response);
		
//		if(uri.equals("list.do")) locationDAO.getList();
//		else if(uri.equals("detail.do")) locationDAO.getDetail();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String useSubString(String data) {
		String result = data.substring(data.lastIndexOf("/") + 1);
		return result;
	}

}
