package d3Soft.hisys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import d3Soft.hisys.dao.HealthCenterDao;
import d3Soft.hisys.model.HealthCenter;

@Transactional
@Service("centerService")
public class HealthCenterServiceImpl implements HealthCenterService {

	@Autowired
	private HealthCenterDao healthCenterDAO;

	public HealthCenterDao getHealthCenterDAO() {
		return healthCenterDAO;
	}

	public void setHealthCenterDAO(HealthCenterDao healthCenterDAO) {
		this.healthCenterDAO = healthCenterDAO;
	}

	@Transactional
	@Override
	public void insert(HealthCenter center) {
		healthCenterDAO.insert(center);
		
	}

	@Transactional
	@Override
	public void update(HealthCenter center) {
		healthCenterDAO.update(center);
	}

	@Transactional
	@Override
	public void delete(HealthCenter center) {
		healthCenterDAO.delete(center);
		
	}

	@Transactional
	@Override
	public HealthCenter byId(int id) {
		
		return healthCenterDAO.byId(id);
	}

	@Transactional
	@Override
	public List<HealthCenter> getAll() {		
		return healthCenterDAO.getAll();
	}
	
	
}
