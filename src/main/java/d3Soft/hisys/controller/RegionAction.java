package d3Soft.hisys.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import d3Soft.hisys.model.Region;
import d3Soft.hisys.service.RegionService;

public class RegionAction  extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RegionAction.class);
	
	@Autowired
	RegionService regionService;
	
	private Region region;
	private List<Region> regions;
	private boolean updated;
	
	
	
	public RegionService getRegionService() {
		return regionService;
	}

	public void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
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

	public String listRegions() {
		 updated=false;
       logger.info("listRegions method called");                  
       regions = regionService.getAll();
       return SUCCESS;
   }
	
	public String addRegion() {
       logger.info("addRegion method called");
       if(updated==false)
       	regionService.insert(region);
       else 
       	regionService.update(region);
       updated=false;
       return SUCCESS;
   }
	public String deleteRegion() {
       logger.info("deleteRegion method called");
       regionService.delete(region);
       return SUCCESS;
   }
	
	public String updateRegion() {
       logger.info("prepareupdateRegion method called");
       updated=true;                       
       regions = regionService.getAll();
       return SUCCESS;
   }
	
	
	 public void prepare() throws Exception {
	        region = null;	        
	    }
	
	

}
