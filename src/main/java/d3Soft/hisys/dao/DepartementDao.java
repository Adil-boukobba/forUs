package d3Soft.hisys.dao;

import java.util.List;

import d3Soft.hisys.model.Departement;

public interface DepartementDao {
	public void insert(Departement departement);
	public void update(Departement departement);
	public void delete(Departement departement);
	public Departement byId(int id);
	public List<Departement> getAll();
}
