package d3Soft.hisys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import d3Soft.hisys.model.Hospital;

@Repository("hospitalDAO")
public class HospitalDaoImpl implements HospitalDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Hospital hospital) {
		sessionFactory.getCurrentSession().save(hospital);		
	}

	@Override
	public void update(Hospital hospital) {
		sessionFactory.getCurrentSession().update(hospital);
		
	}

	@Override
	public void delete(Hospital hospital) {
		sessionFactory.getCurrentSession().delete(hospital);
		
	}

	@Override
	public Hospital byId(int id) {		
		return (Hospital) sessionFactory.getCurrentSession().get(Hospital.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hospital> getAll() {

		return sessionFactory.getCurrentSession().createQuery("from Hospital").list();
	}

	
}
