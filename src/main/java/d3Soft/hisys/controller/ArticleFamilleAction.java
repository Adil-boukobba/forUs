package d3Soft.hisys.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import d3Soft.hisys.model.ArticleFamille;
import d3Soft.hisys.service.ArticleFamilleService;

public class ArticleFamilleAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ArticleFamilleAction.class);
	
	@Autowired
	ArticleFamilleService articleFamilleService;
	
	
	private ArticleFamille toUse;
	private ArticleFamille famille;
	private List<ArticleFamille> familles;
	
	public ArticleFamilleService getArticleFamilleService() {
		return articleFamilleService;
	}

	public void setArticleFamilleService(ArticleFamilleService articleFamilleService) {
		this.articleFamilleService = articleFamilleService;
	}	
	
	
	public ArticleFamille getFamille() {
		return famille;
	}

	public void setFamille(ArticleFamille famille) {
		this.famille = famille;
	}

	public List<ArticleFamille> getFamilles() {
		return familles;
	}

	public void setFamilles(List<ArticleFamille> familles) {
		this.familles = familles;
	}

	
	
	
	
	public ArticleFamille getToUse() {
		return toUse;
	}

	public void setToUse(ArticleFamille toUse) {
		this.toUse = toUse;
	}

	public String listFamilles() {
        logger.info("listArticles method called");    
        familles= articleFamilleService.getAll();
        return SUCCESS;
    }
	
	public String addFamille() {
        logger.info("addArticle method called");
        articleFamilleService.insert(famille);
        return SUCCESS;
    }
	public String deleteFamille() {
        logger.info("deleteArticle method called");
        articleFamilleService.delete(famille);
        return SUCCESS;
    }
	
	public String toUpdate()
	{
		logger.info("prepare to update called");
		toUse=articleFamilleService.byId(famille.getId());
		return SUCCESS;		
	}
	
	public String updateFamille() {
        logger.info("updateArticle method called");
        articleFamilleService.update(famille);
        return SUCCESS;
    }
	
//	 public void prepare() throws Exception {
//	        famille = null;
//	        
//	    }
//	
	
}
