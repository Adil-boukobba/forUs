package d3Soft.hisys.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import d3Soft.hisys.model.City;

@Repository("cityDAO")
public class CityDaoImpl implements CityDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(City city) {
		sessionFactory.getCurrentSession().save(city);
		
	}

	@Override
	public void update(City city) {
		sessionFactory.getCurrentSession().update(city);
		
	}

	@Override
	public void delete(City city) {
		sessionFactory.getCurrentSession().delete(city);
		
	}

	@Override
	public City byId(int id) {
		return (City) sessionFactory.getCurrentSession().get(City.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from City").list();
	}

	
}
