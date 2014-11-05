package d3Soft.hisys.service;

import java.util.List;

import d3Soft.hisys.model.HealthCenter;

public interface HealthCenterService {

	  public void insert(HealthCenter center);
	    public void update(HealthCenter center);
	    public void delete(HealthCenter center);
	    public HealthCenter byId(int id);
	    public List<HealthCenter> getAll();
}
