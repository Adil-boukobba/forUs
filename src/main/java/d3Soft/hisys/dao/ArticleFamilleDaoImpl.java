package d3Soft.hisys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import d3Soft.hisys.model.ArticleFamille;

@Repository("articleFamilleDAO")
public class ArticleFamilleDaoImpl implements ArticleFamilleDao{

	@Autowired
	SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	
	@Override
	public void insert(ArticleFamille articlefamile) {
		sessionFactory.getCurrentSession().save(articlefamile);
		
	}


	
	@Override
	public void update(ArticleFamille articlefamile) {
		sessionFactory.getCurrentSession().update(articlefamile);
		
	}


	
	@Override
	public void delete(ArticleFamille articlefamile) {

		sessionFactory.getCurrentSession().delete(articlefamile);
		
	}



	@Override
	public ArticleFamille byId(int id) {

		return (ArticleFamille) sessionFactory.getCurrentSession().get(ArticleFamille.class, id);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleFamille> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from ArticleFamille").list();
	}



	

}
