package com.winter.app.products;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.app.ActionForward;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService productService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
       productService = new ProductService();
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
		actionForward.setPath("/WEB-INF/views/errors/error.jsp");
		try {
			if(uri.equals("list.do")) {
				productService.getList(request, actionForward);
			} else if(uri.equals("detail.do")) {
				productService.getDetail(request, actionForward);
			} else if(uri.equals("add.do")) {
				String method = request.getMethod();
				if(method.toUpperCase().equals("POST")) {
					productService.add(request, actionForward);
				}else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/products/add.jsp");
				}
			} else if(uri.equals("update.do")) {
				String method = request.getMethod();
				if(method.toUpperCase().equals("POST")) {
					productService.updateProcess(request, actionForward);
				}else {
					productService.update(request, actionForward);
				}
			} else if(uri.equals("delete.do")) {
				productService.deleteProcess(request, actionForward);
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
