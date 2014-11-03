package d3Soft.hisys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import d3Soft.hisys.model.Region;

@Repository("regionDAO")
public class RegionDaoImpl implements RegionDao{

	@Autowired
	SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Region region) {
		sessionFactory.getCurrentSession().save(region);
		
	}

	@Override
	public void update(Region region) {
		sessionFactory.getCurrentSession().update(region);
		
	}

	@Override
	public void delete(Region region) {
		sessionFactory.getCurrentSession().delete(region);
		
	}

	@Override
	public Region byId(int id) {
		return (Region) sessionFactory.getCurrentSession().get(Region.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> getAll() {		
		return sessionFactory.getCurrentSession().createQuery("from Region").list();
	}

}
