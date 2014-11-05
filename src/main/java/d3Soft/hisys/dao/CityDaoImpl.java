package d3Soft.hisys.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<City> search(City city) {

		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(City.class);
		
		if(city!=null){
			if(city.getId()>0)
			{
				criteria.add(Restrictions.eq("id", city.getId()));
				return criteria.list();
			}
			
			if(city.getCode()>0)
			{
				criteria.add(Restrictions.eq("code", city.getCode()));
			}
			if(city.getName()!=null)
			{
				criteria.add(Restrictions.like("name", "%"+city.getName()+"%"));
			}
			if(city.getRegion()!=null)
			{
				criteria.createCriteria("region")
				.add(Restrictions.like("name", "%"+city.getRegion().getName()+"%"));
			}
			return criteria.list();
	}
		return getAll();
	}

	
}
