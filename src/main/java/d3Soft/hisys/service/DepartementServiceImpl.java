package d3Soft.hisys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import d3Soft.hisys.dao.DepartementDao;
import d3Soft.hisys.model.Departement;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("departementService")
public class DepartementServiceImpl implements DepartementService{

	@Autowired
	private DepartementDao departementDAO;
	
	public DepartementDao getDepartementDAO() {
		return departementDAO;
	}

	public void setDepartementDAO(DepartementDao departementDAO) {
		this.departementDAO = departementDAO;
	}

	@Transactional
	@Override
	public void insert(Departement departement) {
		departementDAO.insert(departement);
		
	}

	@Transactional
	@Override
	public void update(Departement departement) {
		departementDAO.update(departement);
		
	}

	@Transactional
	@Override
	public void delete(Departement departement) {
		departementDAO.delete(departement);
		
	}

	@Transactional
	@Override
	public Departement byId(Departement departement) {
		return departementDAO.byId(departement.getId());
	}

	@Transactional
	@Override
	public List<Departement> getAll() {
		return departementDAO.getAll();
	}

	
	
}
