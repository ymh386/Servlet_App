package com.winter.app.accounts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.app.ActionForward;

public class AccountService {
	
	private AccountDAO accountDAO;
	
	public AccountService() {
		// TODO Auto-generated constructor stub
		accountDAO = new AccountDAO();
	}
	
	public void add(HttpServletRequest request, ActionForward actionForward) throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setUserName(request.getParameter("userName"));
		accountDTO.setProductNum(Long.parseLong(request.getParameter("productNum")));
		accountDTO.setAccountNum(request.getParameter("accountNum"));
		
		int result = accountDAO.add(accountDTO);
		
		actionForward.setFlag(false);
		actionForward.setPath("../users/mypage.do");
	}
	
	public ActionForward getDetail(HttpServletRequest request, ActionForward actionForward) throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNum(request.getParameter("accountNum"));
		accountDTO = accountDAO.getDetail(accountDTO);
		
		request.setAttribute("dto", accountDTO);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/accounts/detail.jsp");
		
		return actionForward;
	}
	
	public ActionForward getList(HttpServletRequest request, ActionForward actionForward) throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setUserName(request.getParameter("userName"));
		List<AccountDTO> ar = accountDAO.getList(accountDTO);
		
		
		request.setAttribute("list", ar);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/accounts/list.jsp");
		
		return actionForward;
	}

}
