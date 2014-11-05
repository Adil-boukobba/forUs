package d3Soft.hisys.service;

import java.util.List;

import d3Soft.hisys.model.Region;

public interface RegionService {
	public void insert(Region region);
	public void update(Region region);
	public void delete(Region region);
	public Region byId(int id);
	public List<Region> getAll();
	public List<Region> search(Region region);
	public void lock(Region region);
	public void unlock(Region region);
}
