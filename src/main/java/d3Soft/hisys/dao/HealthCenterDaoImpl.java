package d3Soft.hisys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import d3Soft.hisys.model.HealthCenter;

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

	@Override
	public List<HealthCenter> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
