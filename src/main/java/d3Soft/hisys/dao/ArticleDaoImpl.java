package d3Soft.hisys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import d3Soft.hisys.model.Article;


@Repository("articleDAO")
public class ArticleDaoImpl implements ArticleDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Article article) {
		sessionFactory.getCurrentSession().save(article);
		
	}

	@Override
	public void update(Article article) {
		sessionFactory.getCurrentSession().update(article);		
	}

	@Override
	public void delete(Article article) { 
		sessionFactory.getCurrentSession().delete(article);
	}

	@Override
	public Article byId(int id) {
		return (Article) sessionFactory.getCurrentSession().get(Article.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAll() {		
		return sessionFactory.getCurrentSession().createQuery("from Article").list();
	}
	
	
	
}
