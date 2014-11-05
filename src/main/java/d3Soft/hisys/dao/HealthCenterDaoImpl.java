package d3Soft.hisys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import d3Soft.hisys.model.HealthCenter;

@Repository("healthCenterDAO")
public class HealthCenterDaoImpl implements HealthCenterDao{

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(HealthCenter center) {
		sessionFactory.getCurrentSession().save(center);
		
	}

	@Override
	public void update(HealthCenter center) {
		sessionFactory.getCurrentSession().update(center);
		
	}

	@Override
	public void delete(HealthCenter center) {
		sessionFactory.getCurrentSession().delete(center);
	}

	@Override
	public HealthCenter byId(int id) {
	
		return (HealthCenter) sessionFactory.getCurrentSession().get(HealthCenter.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HealthCenter> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from HealthCenter").list();
	}
	
	
	
}
