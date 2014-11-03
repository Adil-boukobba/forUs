package d3Soft.hisys.service;

import java.util.List;

import d3Soft.hisys.model.Departement;;

public interface DepartementService {

	public void insert(Departement departement);
	public void update(Departement departement);
	public void delete(Departement departement);
	public Departement byId(Departement departement);
	public List<Departement> getAll();
	
}
