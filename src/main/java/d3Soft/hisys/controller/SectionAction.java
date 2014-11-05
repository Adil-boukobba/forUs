package d3Soft.hisys.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import d3Soft.hisys.model.Departement;
import d3Soft.hisys.model.Section;
import d3Soft.hisys.service.DepartementService;
import d3Soft.hisys.service.SectionService;

public class SectionAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private SectionService sectionService;
	@Autowired
	private DepartementService departementService;
	
	private static final Logger logger = Logger.getLogger(SectionAction.class);
	
	private List<Section> sections;
	private Section section;
	private List<Departement> departements;
	private boolean updated;
	
	
	public List<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	public SectionService getSectionService() {
		return sectionService;
	}
	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	public DepartementService getDepartementService() {
		return departementService;
	}
	public void setDepartementService(DepartementService departementService) {
		this.departementService = departementService;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public boolean isUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	
	public String listSections() {
		 updated=false;
       logger.info("listSections method called"); 
       departements= departementService.getAll();
       sections = sectionService.getAll();
       return SUCCESS;
   }
	public String addSection() {
        logger.info("addSection method called");
        if(updated==false)
        	sectionService.insert(section);
        else 
        	sectionService.update(section);
        updated=false;
        return SUCCESS;
    }
	
	public String deleteSection() {
        logger.info("deleteSection method called");
        sectionService.delete(section);
        return SUCCESS;
    }
	
	public String updateSection() {
        logger.info("prepareupdateSection method called");
        updated=true;    
        section= sectionService.byId(section);
        departements= departementService.getAll();
        sections = sectionService.getAll();
        return SUCCESS;
    }
	public void prepare() throws Exception {
        section = null;
        System.out.println("first running...");
    }
}
