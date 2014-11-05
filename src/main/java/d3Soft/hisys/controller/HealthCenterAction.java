package d3Soft.hisys.controller;

import java.util.List;

import org.apache.log4j.Logger;







import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import d3Soft.hisys.model.City;
import d3Soft.hisys.model.HealthCenter;
import d3Soft.hisys.service.CityService;
import d3Soft.hisys.service.HealthCenterService;

public class HealthCenterAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HealthCenterAction.class);
	
	@Autowired
	private HealthCenterService centerService;
	@Autowired
	private CityService cityService;
	
	private boolean updated;
	private HealthCenter center;
	private List<HealthCenter> centers; 
	private List<City> cities;
	
	
	
	public boolean isUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	public HealthCenterService getCenterService() {
		return centerService;
	}
	public void setCenterService(HealthCenterService centerService) {
		this.centerService = centerService;
	}
	public CityService getCityService() {
		return cityService;
	}
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
	public HealthCenter getCenter() {
		return center;
	}
	public void setCenter(HealthCenter center) {
		this.center = center;
	}
	public List<HealthCenter> getCenters() {
		return centers;
	}
	public void setCenters(List<HealthCenter> centers) {
		this.centers = centers;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	
	
	
	public String listCenters() {
		 updated=false;
        logger.info("listCenters method called");              
        cities= cityService.getAll();
         centers= centerService.getAll();
        return SUCCESS;
    }
	
	public String addCenter() {
        logger.info("addCenter method called");
        if(updated==false)
        	centerService.insert(center);
        else 
        	centerService.update(center);
        updated=false;
        return SUCCESS;
    }
	public String deleteCenter() {
        logger.info("deleteCenter method called");
        centerService.delete(center);
        return SUCCESS;
    }
	
	public String updateCenter() {
        logger.info("prepareupdateCenter method called");
        updated=true;   
        center=centerService.byId(center.getId());
        cities= cityService.getAll();
        centers = centerService.getAll();
        return SUCCESS;
    }
	
	
	 public void prepare() throws Exception {
	        center = null;	        
	    }
	
	
	
	
	
}
