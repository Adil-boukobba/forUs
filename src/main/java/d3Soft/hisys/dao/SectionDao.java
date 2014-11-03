package d3Soft.hisys.dao;

import java.util.List;

import d3Soft.hisys.model.Section;

public interface SectionDao {

	public void insert(Section section);
	public void update(Section section);
	public void delete(Section section);
	public Section byId(int id);
	public List<Section> getAll();
}
