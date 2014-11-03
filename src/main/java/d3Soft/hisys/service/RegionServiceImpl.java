package d3Soft.hisys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import d3Soft.hisys.dao.RegionDao;
import d3Soft.hisys.model.Region;

@Transactional
@Service("regionService")
public class RegionServiceImpl implements RegionService{

	@Autowired
	RegionDao regionDAO;
	
	
	
	
	public RegionDao getRegionDAO() {
		return regionDAO;
	}

	public void setRegionDAO(RegionDao regionDAO) {
		this.regionDAO = regionDAO;
	}

	@Transactional
	@Override
	public void insert(Region region) {
		regionDAO.insert(region);
		
	}

	@Transactional
	@Override
	public void update(Region region) {
		regionDAO.update(region);
		
	}

	@Transactional
	@Override
	public void delete(Region region) {
		regionDAO.delete(region);
		
	}

	@Transactional
	@Override
	public Region byId(int id) {	
		return regionDAO.byId(id);
	}

	@Transactional
	@Override
	public List<Region> getAll() {		
		return regionDAO.getAll();
	}

}
