package com.winter.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.utils.DBConnection;

public class LocationDAO {
	
	public int update(LocationDTO locationDTO) throws Exception {
		int result = 0;
		Connection con = DBConnection.getConnection();
		String sql = "UPDATE LOCATIONS SET STREET_ADDRESS=?, POSTAL_CODE=?, CITY=?, STATE_PROVINCE=?, COUNTRY_ID=?"
				+ " WHERE LOCATION_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setString(3, locationDTO.getCity());
		st.setString(4, locationDTO.getState_province());
		st.setString(5, locationDTO.getCountry_id());
		st.setInt(6, locationDTO.getLocation_id());
		
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
	}
	
	public int delete(LocationDTO locationDTO) throws Exception {
		int result = 0;
		Connection con = DBConnection.getConnection();
		String sql = "DELETE LOCATIONS WHERE LOCATION_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, locationDTO.getLocation_id());
		
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
	}
	
	public int add(LocationDTO locationDTO) throws Exception {
		int result = 0;
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO LOCATIONS VALUES"
				+ " (LOCATIONS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setString(3, locationDTO.getCity());
		st.setString(4, locationDTO.getState_province());
		st.setString(5, locationDTO.getCountry_id());
		
		result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
	}
	
	public List<LocationDTO> getList() throws Exception {
		List<LocationDTO> ar = new ArrayList<LocationDTO>();
		LocationDTO locationDTO = null;
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID DESC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			
			ar.add(locationDTO);
		}
		
		DBConnection.disConnect(rs, st, con);
		
		return ar;
	}
	
	public LocationDTO getDetail(LocationDTO locationDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, locationDTO.getLocation_id());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
		}else {
			locationDTO = null;
		}
		DBConnection.disConnect(rs, st, con);
		return locationDTO;
		
	}

}
