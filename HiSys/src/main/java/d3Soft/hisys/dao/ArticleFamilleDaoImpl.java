package d3Soft.hisys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ArticleFamilleDAO")
public class ArticleFamilleDaoImpl implements ArticleFamilleDao{

	@Autowired
	SessionFactory SessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}



	@Override
	public List filtreFamille() {
		
		return SessionFactory.getCurrentSession().createQuery("Select f.id, f.nbr from ArticleFamille f").list();
	
	}

}
