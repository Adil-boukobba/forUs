package d3Soft.hisys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import d3Soft.hisys.model.Departement;

@Repository("departementDAO")
public class DepartementDaoImpl implements DepartementDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void insert(Departement departement) {
		sessionFactory.getCurrentSession().save(departement);
		
	}

	@Override
	public void update(Departement departement) {
		sessionFactory.getCurrentSession().update(departement);	
		
	}

	@Override
	public void delete(Departement departement) {
		sessionFactory.getCurrentSession().delete(departement);
		
	}

	@Override
	public Departement byId(int id) {
		return (Departement) sessionFactory.getCurrentSession().get(Departement.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departement> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Departement").list();
	}

	
	
}
