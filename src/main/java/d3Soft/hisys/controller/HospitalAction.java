package d3Soft.hisys.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import d3Soft.hisys.model.HealthCenter;
import d3Soft.hisys.model.Hospital;
import d3Soft.hisys.service.HealthCenterService;
import d3Soft.hisys.service.HospitalService;

public class HospitalAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HospitalAction.class);
	
	private HospitalService hospitalService;
	private HealthCenterService centerService;
	
	private boolean updated;
	private Hospital hospital;
	private List<Hospital> hospitals;
	private List<HealthCenter> centers;
	public HospitalService getHospitalService() {
		return hospitalService;
	}
	public void setHospitalService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}
	public HealthCenterService getCenterService() {
		return centerService;
	}
	public void setCenterService(HealthCenterService centerService) {
		this.centerService = centerService;
	}
	public boolean isUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public List<Hospital> getHospitals() {
		return hospitals;
	}
	public void setHospitals(List<Hospital> hospitals) {
		this.hospitals = hospitals;
	}
	public List<HealthCenter> getCenters() {
		return centers;
	}
	public void setCenters(List<HealthCenter> centers) {
		this.centers = centers;
	}
	
	
	
	public String listHospitals() {
		 updated=false;
        logger.info("listHospitals method called");              
        centers= centerService.getAll();
        hospitals = hospitalService.getAll();
        return SUCCESS;
    }
	
	public String addHospital() {
        logger.info("addHospital method called");
        if(updated==false)
        	hospitalService.insert(hospital);
        else 
        	hospitalService.update(hospital);
        updated=false;
        return SUCCESS;
    }
	public String deleteHospital() {
        logger.info("deleteHospital method called");
        hospitalService.delete(hospital);
        return SUCCESS;
    }
	
	public String updateHospital() {
        logger.info("prepareupdateHospital method called");
        updated=true;   
        hospital=hospitalService.byId(hospital.getId());
        centers= centerService.getAll();
        hospitals = hospitalService.getAll();
        return SUCCESS;
    }
	
	
	 public void prepare() throws Exception {
	        hospital = null;	        
	    }
	
	
	
	
}
