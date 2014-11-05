package d3Soft.hisys.dao;

import java.util.List;

import d3Soft.hisys.model.Hospital;

public interface HospitalDao {

	public void insert(Hospital hospital);
	public void update(Hospital hospital);
	public void delete(Hospital hospital);
	public Hospital byId(int id);
	public List<Hospital> getAll();
}
