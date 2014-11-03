package d3Soft.hisys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import d3Soft.hisys.model.Section;


@Repository("sectionDAO")
public class SectionDaoImpl implements SectionDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void insert(Section section) {
		sessionFactory.getCurrentSession().save(section);
		
	}

	@Override
	public void update(Section section) {
		sessionFactory.getCurrentSession().update(section);	
		
	}

	@Override
	public void delete(Section section) {
		sessionFactory.getCurrentSession().delete(section);
		
	}

	@Override
	public Section byId(int id) {
		return (Section) sessionFactory.getCurrentSession().get(Section.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Section> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Section").list();
	}

	
	
}
