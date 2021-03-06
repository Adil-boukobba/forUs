package d3Soft.hisys.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import d3Soft.hisys.model.Article;
import d3Soft.hisys.model.ArticleFamille;
import d3Soft.hisys.model.ArticleGroup;
import d3Soft.hisys.service.ArticleFamilleService;
import d3Soft.hisys.service.ArticleGroupService;
import d3Soft.hisys.service.ArticleService;


public class ArticleAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleFamilleService articleFamilleService;
	@Autowired
	private ArticleGroupService articleGroupService;
	
	
	private static final Logger logger = Logger.getLogger(ArticleAction.class);
	
	
	private List<ArticleFamille> familles;
	private List<ArticleGroup> groups;
	private List<Article> articles;
	private Article article;
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
	public List<ArticleFamille> getFamilles() {
		return familles;
	}
	public void setFamilles(List<ArticleFamille> familles) {
		this.familles = familles;
	}
	public List<ArticleGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<ArticleGroup> groups) {
		this.groups = groups;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
		
	
	public String listArticles() {
		 updated=false;
        logger.info("listArticles method called");      
        familles= articleFamilleService.getAll();
        groups= articleGroupService.getAll();
        articles = articleService.getAll();
        return SUCCESS;
    }
	
	public String addArticle() {
        logger.info("addArticle method called");
        if(updated==false)
        	articleService.insert(article);
        else 
        	articleService.update(article);
        updated=false;
        return SUCCESS;
    }
	public String deleteArticle() {
        logger.info("deleteArticle method called");
        articleService.delete(article);
        return SUCCESS;
    }
	
	public String updateArticle() {
        logger.info("prepareupdateArticle method called");
        updated=true;               
        familles= articleFamilleService.getAll();
        groups= articleGroupService.getAll();
        articles = articleService.getAll();
        return SUCCESS;
    }
	
	
	 public void prepare() throws Exception {
	        article = null;
	        System.out.println("first running...");
	    }
	
}
