package com.winter.app.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.utils.DBConnection;

public class CountryDAO {
	
	public List<CountryDTO> getList() throws Exception {
		List<CountryDTO> ar = new ArrayList<CountryDTO>();
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM COUNTRIES ORDER BY COUNTRY_ID DESC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			CountryDTO countryDTO = new CountryDTO();
			countryDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			countryDTO.setCountry_name(rs.getString("COUNTRY_NAME"));
			countryDTO.setRegion_id(rs.getInt("REGION_ID"));
			
			ar.add(countryDTO);
		}
		
		DBConnection.disConnect(rs, st, con);
		
		return ar;
	}
	
	public CountryDTO getDetail(CountryDTO countryDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, countryDTO.getCountry_id());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			countryDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			countryDTO.setCountry_name(rs.getString("COUNTRY_NAME"));
			countryDTO.setRegion_id(rs.getInt("REGION_ID"));
		}else {
			countryDTO = null;
		}
		
		DBConnection.disConnect(rs, st, con);
		
		return countryDTO;
	}
	
	public int add(CountryDTO countryDTO) throws Exception {
		int result = 0;
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO COUNTRIES VALUES"
				+ " (?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, countryDTO.getCountry_id());
		st.setString(2, countryDTO.getCountry_name());
		st.setInt(3, countryDTO.getRegion_id());
		
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		
		return result;
	}
	
	public int delete(CountryDTO countryDTO) throws Exception {
		int result = 0;
		Connection con = DBConnection.getConnection();
		String sql = "DELETE COUNTRIES WHERE COUNTRY_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, countryDTO.getCountry_id());
		
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
	}
	
	public int update(CountryDTO countryDTO) throws Exception {
		int result = 0;
		Connection con = DBConnection.getConnection();
		String sql = "UPDATE COUNTRIES SET COUNTRY_NAME=?, REGION_ID=?"
				+ " WHERE COUNTRY_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, countryDTO.getCountry_name());
		st.setInt(2, countryDTO.getRegion_id());
		st.setString(3, countryDTO.getCountry_id());
		
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
	}

}
