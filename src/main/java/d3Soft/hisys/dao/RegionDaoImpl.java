package d3Soft.hisys.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

	@SuppressWarnings("deprecation")
	@Override
	public void delete(Region region) {
		sessionFactory.getCurrentSession().delete(region);
		sessionFactory.getCurrentSession().lock(region, LockMode.UPGRADE);
		
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> search(Region region) {		
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Region.class);
		
		if(region!=null){
			if(region.getId()>0)
			{
				criteria.add(Restrictions.eq("id", region.getId()));
				return criteria.list();
			}
			
			if(region.getCode()>0)
			{
				criteria.add(Restrictions.eq("code", region.getCode()));
			}
			if(region.getName()!=null)
			{
				criteria.add(Restrictions.like("name", "%"+region.getName()+"%"));
			}			
			return criteria.list();
	}
		return getAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void lock(Region region) {		
		sessionFactory.getCurrentSession().lock(region, LockMode.UPGRADE);		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void unlock(Region region) {		
		sessionFactory.getCurrentSession().lock(region, LockMode.NONE);		
	}
	
	
	
}
