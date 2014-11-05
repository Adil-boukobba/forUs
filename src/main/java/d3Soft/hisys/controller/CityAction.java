package d3Soft.hisys.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import d3Soft.hisys.model.City;
import d3Soft.hisys.model.Region;
import d3Soft.hisys.service.CityService;
import d3Soft.hisys.service.RegionService;

public class CityAction {
	
	private static final Logger logger = Logger.getLogger(CityAction.class);
	
	@Autowired
	private CityService cityService;
	@Autowired
	RegionService regionService;
	
	private City city;
	private boolean updated;
	private List<City> cities;
	
	private List<Region> regions;

	public CityService getCityService() {
		return cityService;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	public RegionService getRegionService() {
		return regionService;
	}

	public void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	
	public String listCities() {
        updated=false;
       logger.info("listCities method called");      
       regions= regionService.getAll();        
       cities = cityService.getAll();
       return "success";
   }
   
   public String addCity() {
       logger.info("addCity method called");
       if(updated==false)
           cityService.insert(city);
       else 
           cityService.update(city);
       updated=false;
       return "success";
   }
   public String deleteCity() {
       logger.info("deleteCity method called");
       cityService.delete(city);
       return "success";
   }
   
   public String updateCity() {
       logger.info("prepareupdateCity method called");
       updated=true;         
       city=cityService.byId(city.getId());
       regions= regionService.getAll();        
       cities = cityService.getAll();
       return "success";
   }
   
	public String searchCity()
	{
		logger.info("search City method called");
		regions= regionService.getAll();  
	     cities = cityService.search(city);
		return "success";
	} 
   
    public void prepare() throws Exception {
           city = null;          
       }
	

}
