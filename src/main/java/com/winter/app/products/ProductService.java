package com.winter.app.products;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.app.ActionForward;

public class ProductService {
	
	private ProductDAO productDAO;
	
	public ProductService() {
		// TODO Auto-generated constructor stub
		productDAO = new ProductDAO();
	}
	
	public void deleteProcess(HttpServletRequest request, ActionForward actionForward) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(Long.parseLong(request.getParameter("productNum")));
		int result = productDAO.delete(productDTO);
		
		String str = "상품 삭제 실패";
		if(result > 0) {
			str = "상품 삭제 성공";
		}
		request.setAttribute("result", str);
		request.setAttribute("path", "./products/list.do");
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
	}
	
	public void updateProcess(HttpServletRequest request, ActionForward actionForward) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(Long.parseLong(request.getParameter("productNum")));
		productDTO.setProductName(request.getParameter("productName"));
		productDTO.setProductRate(Double.parseDouble(request.getParameter("productRate")));
		productDTO.setProductDate(Date.valueOf(request.getParameter("productDate")));
		productDTO.setProductDetail(request.getParameter("productDetail"));
		int result = productDAO.update(productDTO);
		
		actionForward.setFlag(false);
		actionForward.setPath("./list.do");
	}
	
	public void update(HttpServletRequest request, ActionForward actionForward) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(Long.parseLong(request.getParameter("productNum")));
		productDTO = productDAO.getDetail(productDTO);
		
		request.setAttribute("dto", productDTO);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/products/update.jsp");
	}
	
	public void add(HttpServletRequest request, ActionForward actionForward) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName(request.getParameter("productName"));
		productDTO.setProductRate(Double.parseDouble(request.getParameter("productRate")));
		productDTO.setProductDate(Date.valueOf(request.getParameter("productDate")));
		productDTO.setProductDetail(request.getParameter("productDetail"));
		int result = productDAO.add(productDTO);
		
		actionForward.setFlag(false);
		actionForward.setPath("./list.do");
		
	}
	
	public ActionForward getDetail(HttpServletRequest request, ActionForward actionForward) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(Long.parseLong(request.getParameter("productNum")));
		productDTO = productDAO.getDetail(productDTO);
		
		request.setAttribute("dto", productDTO);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/products/detail.jsp");
		
		return actionForward;
	}
	
	public ActionForward getList(HttpServletRequest request, ActionForward actionForward) throws Exception {
		List<ProductDTO> ar = productDAO.getList();
		request.setAttribute("list", ar);
		
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/products/list.jsp");
		return actionForward;
	}

}
