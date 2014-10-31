package d3Soft.hisys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import d3Soft.hisys.dao.ArticleFamilleDao;

@Service("articleFamilleService")
public class ArticleFamilleServiceImpl implements ArticleFamilleService {

	@Autowired
	private ArticleFamilleDao ArticleFamilleDAO;
	
	

	public ArticleFamilleDao getArticleFamilleDAO() {
		return ArticleFamilleDAO;
	}


	public void setArticleFamilleDAO(ArticleFamilleDao articleFamilleDAO) {
		ArticleFamilleDAO = articleFamilleDAO;
	}






	@Transactional
	@Override
	public List filtreFamille() {
		// TODO Auto-generated method stub
		return ArticleFamilleDAO.filtreFamille();
	}

}
