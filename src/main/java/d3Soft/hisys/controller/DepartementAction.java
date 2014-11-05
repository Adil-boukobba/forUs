package d3Soft.hisys.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import d3Soft.hisys.model.Departement;
import d3Soft.hisys.model.Hospital;
import d3Soft.hisys.service.DepartementService;
import d3Soft.hisys.service.HospitalService;

public class DepartementAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private DepartementService departementService;
	
	@Autowired
	private HospitalService hospitalService;
	
	private static final Logger logger = Logger.getLogger(DepartementAction.class);
	
	
	
	public HospitalService getHospitalService() {
		return hospitalService;
	}
	public void setHospitalService(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}
	private List<Departement> departements;
	private Departement departement;
	private List<Hospital> hospitals;
	
	
	
	public List<Hospital> getHospitals() {
		return hospitals;
	}
	public void setHospitals(List<Hospital> hospitals) {
		this.hospitals = hospitals;
	}
	private boolean updated;
	public DepartementService getDepartementService() {
		return departementService;
	}
	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
	}
	public List<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	public boolean isUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public String listDepartements() {
		 updated=false;
       logger.info("listDepartements method called");    
       hospitals= hospitalService.getAll();
       departements = departementService.getAll();
       return SUCCESS;
   }
	public String addDepartement() {
        logger.info("addDepartement method called");
        if(updated==false)
        	departementService.insert(departement);
        else 
        	departementService.update(departement);
        updated=false;
        return SUCCESS;
    }
	public String deleteDepartement() {
        logger.info("deleteDepartement method called");
        departementService.delete(departement);
        return SUCCESS;
    }
	public String updateDepartement() {
        logger.info("prepareupdateDepartement method called");
        updated=true;             
        departement=departementService.byId(departement);
        hospitals= hospitalService.getAll();
        departements = departementService.getAll();
        return SUCCESS;
    }
	public void prepare() throws Exception {
		departement = null;
        System.out.println("first running...");
    }
}
