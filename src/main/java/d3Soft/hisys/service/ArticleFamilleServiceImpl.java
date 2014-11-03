package d3Soft.hisys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import d3Soft.hisys.dao.ArticleFamilleDao;
import d3Soft.hisys.model.ArticleFamille;

@Service("articleFamilleService")
public class ArticleFamilleServiceImpl implements ArticleFamilleService {

	@Autowired
	private ArticleFamilleDao articleFamilleDAO;
	
	

	public ArticleFamilleDao getArticleFamilleDAO() {
		return articleFamilleDAO;
	}


	public void setArticleFamilleDAO(ArticleFamilleDao articleFamilleDAO) {
		this.articleFamilleDAO = articleFamilleDAO;
	}

	@Transactional
	@Override
	public void insert(ArticleFamille articlefamile) {
		articleFamilleDAO.insert(articlefamile);
		
	}

	@Transactional
	@Override
	public void update(ArticleFamille articlefamile) {
		articleFamilleDAO.update(articlefamile);
		
	}

	@Transactional
	@Override
	public void delete(ArticleFamille articlefamile) {
		articleFamilleDAO.delete(articlefamile);
		
	}

	@Transactional
	@Override
	public ArticleFamille byId(int id) {
		
		return articleFamilleDAO.byId(id);
	}

	@Transactional
	@Override
	public List<ArticleFamille> getAll() {
		
		return articleFamilleDAO.getAll();
	}






	

}
