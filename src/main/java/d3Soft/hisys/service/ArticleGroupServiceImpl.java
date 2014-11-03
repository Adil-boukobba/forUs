package d3Soft.hisys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import d3Soft.hisys.dao.ArticleGroupDao;
import d3Soft.hisys.model.ArticleGroup;

@Service("articleGroupService")
public class ArticleGroupServiceImpl implements ArticleGroupService{

	
	@Autowired
	ArticleGroupDao articleGroupDAO;
	
	
	public ArticleGroupDao getArticleGroupDAO() {
		return articleGroupDAO;
	}

	public void setArticleGroupDAO(ArticleGroupDao articleGroupDAO) {
		this.articleGroupDAO = articleGroupDAO;
	}

	@Transactional
	@Override
	public void insert(ArticleGroup group) {
		
		articleGroupDAO.insert(group);
	}

	@Transactional
	@Override
	public void update(ArticleGroup group) {
		articleGroupDAO.update(group);
		
	}

	@Transactional
	@Override
	public void delete(ArticleGroup group) {
		articleGroupDAO.delete(group);
		
	}

	@Transactional
	@Override
	public ArticleGroup byId(int id) {
		
		return articleGroupDAO.byId(id);
	}
	@Transactional
	@Override
	public List<ArticleGroup> getAll() {		
		return articleGroupDAO.getAll();
	}

}
