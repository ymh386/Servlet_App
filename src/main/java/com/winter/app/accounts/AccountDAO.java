package com.winter.app.accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.utils.DBConnection;

public class AccountDAO {
	
	public List<AccountDTO> getList(AccountDTO accountDTO) throws Exception {
		List<AccountDTO> ar = new ArrayList<AccountDTO>();
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM ACCOUNTS WHERE USERNAME=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, accountDTO.getUserName());
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			AccountDTO accountDTO2 = new AccountDTO();
			accountDTO2.setUserName(rs.getString("USERNAME"));
			accountDTO2.setAccountNum(rs.getString("ACCOUNTNUM"));
			accountDTO2.setProductNum(rs.getLong("PRODUCTNUM"));
			accountDTO2.setAccountBalance(rs.getLong("ACCOUNTBALANCE"));
			accountDTO2.setAccountDate(rs.getDate("ACCOUNTDATE"));
			
			ar.add(accountDTO2);
		}
		
		DBConnection.disConnect(rs, st, con);
		
		return ar;
	}
	
	public AccountDTO getDetail(AccountDTO accountDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM ACCOUNTS WHERE ACCOUNTNUM=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, accountDTO.getAccountNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			accountDTO.setUserName(rs.getString("USERNAME"));
			accountDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			accountDTO.setAccountBalance(rs.getLong("ACCOUNTBALANCE"));
			accountDTO.setAccountDate(rs.getDate("ACCOUNTDATE"));
		}
		
		DBConnection.disConnect(rs, st, con);
		
		return accountDTO;
	}
	
	public int add(AccountDTO accountDTO) throws Exception {
		int result = 0;
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO ACCOUNTS VALUES (?, ?, ?, 0, SYSDATE)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, accountDTO.getAccountNum());
		st.setString(2, accountDTO.getUserName());
		st.setLong(3, accountDTO.getProductNum());
		
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
	}

}
