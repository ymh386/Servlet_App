package com.winter.app.tests.locations;

import java.util.List;

import com.winter.app.locations.LocationDAO;
import com.winter.app.locations.LocationDTO;

public class LocationDAOTest {
	
	public static void main(String[] args) {
		LocationDTO locationDTO = new LocationDTO();
		LocationDAO locationDAO = new LocationDAO();
		
		List<LocationDTO> ar;
		try {
			ar = locationDAO.getList();
			System.out.println(ar.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
