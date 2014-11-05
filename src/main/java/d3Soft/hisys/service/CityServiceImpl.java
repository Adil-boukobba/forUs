package d3Soft.hisys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import d3Soft.hisys.dao.CityDao;
import d3Soft.hisys.model.City;

@Transactional
@Service("cityService")
public class CityServiceImpl implements CityService {

	@Autowired
	CityDao cityDAO;

	public CityDao getCityDAO() {
		return cityDAO;
	}

	public void setCityDAO(CityDao cityDAO) {
		this.cityDAO = cityDAO;
	}

	@Transactional
	@Override
	public void insert(City city) {
		cityDAO.insert(city);
		
	}

	@Transactional
	@Override
	public void update(City city) {
		cityDAO.update(city);
		
	}

	@Transactional
	@Override
	public void delete(City city) {
		cityDAO.delete(city);
		
	}

	@Transactional
	@Override
	public City byId(int id) {	
		return cityDAO.byId(id);
	}

	@Transactional
	@Override
	public List<City> getAll() {		
		return cityDAO.getAll();
	}

	@Transactional
	@Override
	public List<City> search(City city) {
 
		return cityDAO.search(city);
	}
	
	
}
