package d3Soft.hisys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import d3Soft.hisys.dao.HospitalDao;
import d3Soft.hisys.model.Hospital;

@Transactional
@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	HospitalDao hospitalDAO;

	public HospitalDao getHospitalDAO() {
		return hospitalDAO;
	}

	public void setHospitalDAO(HospitalDao hospitalDAO) {
		this.hospitalDAO = hospitalDAO;
	}

	@Transactional
	@Override
	public void insert(Hospital hospital) {
		hospitalDAO.insert(hospital);
		
	}

	@Transactional
	@Override
	public void update(Hospital hospital) {
		hospitalDAO.update(hospital);
		
	}

	@Transactional
	@Override
	public void delete(Hospital hospital) {
		hospitalDAO.delete(hospital);
		
	}

	@Transactional
	@Override
	public Hospital byId(int id) {		
		return hospitalDAO.byId(id);
	}

	@Transactional
	@Override
	public List<Hospital> getAll() {

		return hospitalDAO.getAll();
	}
	
	
}
