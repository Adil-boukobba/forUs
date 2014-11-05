package d3Soft.hisys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import d3Soft.hisys.dao.SectionDao;
import d3Soft.hisys.model.Section;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("sectionService")
public class SectionServiceImpl implements SectionService{

	@Autowired
	private SectionDao sectionDAO;
	
	public SectionDao getSectionDAO() {
		return sectionDAO;
	}

	public void setSectionDAO(SectionDao sectionDAO) {
		this.sectionDAO = sectionDAO;
	}

	@Transactional
	@Override
	public void insert(Section section) {
		sectionDAO.insert(section);
		
	}

	@Transactional
	@Override
	public void update(Section section) {
		sectionDAO.update(section);
		
	}

	@Transactional
	@Override
	public void delete(Section section) {
		sectionDAO.delete(section);
		
	}

	@Transactional
	@Override
	public Section byId(Section section) {
		return sectionDAO.byId(section.getId());
	}

	@Transactional
	@Override
	public List<Section> getAll() {
		return sectionDAO.getAll();
	}

	
}
