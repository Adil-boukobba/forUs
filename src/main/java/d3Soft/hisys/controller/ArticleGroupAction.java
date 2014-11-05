package d3Soft.hisys.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import d3Soft.hisys.model.ArticleFamille;
import d3Soft.hisys.model.ArticleGroup;
import d3Soft.hisys.service.ArticleFamilleService;
import d3Soft.hisys.service.ArticleGroupService;

public class ArticleGroupAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(ArticleGroupAction.class);
	@Autowired
	private ArticleGroupService articleGroupService;
	@Autowired
	private ArticleFamilleService articleFamilleService;
	
	private ArticleGroup group;
	private List<ArticleGroup> groups;
	private List<ArticleFamille> familles;
	private boolean updated;
	
	
	public boolean isUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	public ArticleGroupService getArticleGroupService() {
		return articleGroupService;
	}
	public void setArticleGroupService(ArticleGroupService articleGroupService) {
		this.articleGroupService = articleGroupService;
	}
	public ArticleFamilleService getArticleFamilleService() {
		return articleFamilleService;
	}
	public void setArticleFamilleService(ArticleFamilleService articleFamilleService) {
		this.articleFamilleService = articleFamilleService;
	}
	public ArticleGroup getGroup() {
		return group;
	}
	public void setGroup(ArticleGroup group) {
		this.group = group;
	}
	public List<ArticleGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<ArticleGroup> groups) {
		this.groups = groups;
	}
	public List<ArticleFamille> getFamilles() {
		return familles;
	}
	public void setFamilles(List<ArticleFamille> familles) {
		this.familles = familles;
	}
	
	
	public String listGroups() {
        logger.info("listGroups method called");   
        familles= articleFamilleService.getAll();
        groups= articleGroupService.getAll();
        return SUCCESS;
    }
	
	public String addGroup() {
        logger.info("addGroup method called");        
        if(updated==false)
        	articleGroupService.insert(group);
        else 
        	articleGroupService.update(group);
        updated=false;
        return SUCCESS;
    }
	public String deleteGroup() {
        logger.info("deleteGroup method called");
        articleGroupService.delete(group);
        return SUCCESS;
    }
	
	public String updateGroup() {
        logger.info("prepareupdategroup method called");
        updated=true;    
        group= articleGroupService.byId(group.getId());
        familles= articleFamilleService.getAll();
        groups= articleGroupService.getAll();       
        return SUCCESS;
    }
	
	 public void prepare() throws Exception {
		 group = null;
	        
	    }
	
}
