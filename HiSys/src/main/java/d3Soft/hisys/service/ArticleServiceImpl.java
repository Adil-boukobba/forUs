package d3Soft.hisys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import d3Soft.hisys.dao.ArticleDao;
import d3Soft.hisys.model.Article;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDAO;
	
	public ArticleDao getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDao articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Transactional
	@Override
	public void insert(Article article) {
		articleDAO.insert(article);
	}

	@Transactional
	@Override
	public void update(Article article) {
		articleDAO.update(article);		
	}

	@Transactional
	@Override
	public void delete(Article article) {
		articleDAO.delete(article);
		
	}

	@Transactional
	@Override
	public Article byId(Article article) {		
		return articleDAO.byId(article.getId());
	}

	@Transactional
	@Override
	public List<Article> getAll() {		
		return articleDAO.getAll();
	}

}

