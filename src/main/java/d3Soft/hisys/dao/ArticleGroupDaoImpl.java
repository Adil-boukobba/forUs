package d3Soft.hisys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import d3Soft.hisys.model.ArticleGroup;

@Repository("articleGroupDAO")
public class ArticleGroupDaoImpl implements ArticleGroupDao{

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(ArticleGroup group) {
		sessionFactory.getCurrentSession().save(group);
		
	}

	@Override
	public void update(ArticleGroup group) {
		sessionFactory.getCurrentSession().update(group);
		
	}

	@Override
	public void delete(ArticleGroup group) {
		sessionFactory.getCurrentSession().delete(group);
		
	}

	@Override
	public ArticleGroup byId(int id) {
		
		return (ArticleGroup) sessionFactory.getCurrentSession().get(ArticleGroup.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleGroup> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from ArticleGroup").list();
	}
	
	
}
