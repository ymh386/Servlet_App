package com.winter.app.locations;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.app.ActionForward;
import com.winter.app.departments.DepartmentDTO;

public class LocationService {
	
	private LocationDAO locationDAO;
	
	public LocationService() {
		// TODO Auto-generated constructor stub
		this.locationDAO = new LocationDAO();
	}
	
	public ActionForward getList(HttpServletRequest request, ActionForward actionForward) throws Exception {
		List<LocationDTO> ar = locationDAO.getList();
		request.setAttribute("list", ar);
		
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/locations/list.jsp");
		return actionForward;
	}
	
	public ActionForward getDetail(HttpServletRequest request, ActionForward actionForward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
		locationDTO = locationDAO.getDetail(locationDTO);
		request.setAttribute("dto", locationDTO);
		
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/locations/detail.jsp");
		return actionForward;
	}
	
	public void add(HttpServletRequest request, ActionForward actionForward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setStreet_address(request.getParameter("street_address"));
		locationDTO.setPostal_code(request.getParameter("postal_code"));
		locationDTO.setCity(request.getParameter("city"));
		locationDTO.setState_province(request.getParameter("state_province"));
		locationDTO.setCountry_id(request.getParameter("country_id"));
		
		int result = locationDAO.add(locationDTO);
		
		String str = "지역 등록 실패";
		if(result > 0) {
			str = "지역 등록 성공";
		}
		request.setAttribute("result", str);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
	}
	
	public void update(HttpServletRequest request, ActionForward actionForward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
		locationDTO = locationDAO.getDetail(locationDTO);
		
		request.setAttribute("dto", locationDTO);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/locations/update.jsp");
	}
	
	public void updateProcess(HttpServletRequest request, ActionForward actionForward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
		locationDTO.setStreet_address(request.getParameter("street_address"));
		locationDTO.setPostal_code(request.getParameter("postal_code"));
		locationDTO.setCity(request.getParameter("city"));
		locationDTO.setState_province(request.getParameter("state_province"));
		locationDTO.setCountry_id(request.getParameter("country_id"));
		
		int result = locationDAO.update(locationDTO);
		
		String str = "지역 수정 실패";
		
		if(result > 0) {
			str = "지역 수정 성공";
		}
		
		request.setAttribute("result", str);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
	}
	
	public void delete(HttpServletRequest request, ActionForward actionForward) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
		int result = locationDAO.delete(locationDTO);
		
		String str = "지역 삭제 실패";
		if(result > 0) {
			str = "지역 삭제 성공";
		}
	
		request.setAttribute("result", str);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
	}

}
