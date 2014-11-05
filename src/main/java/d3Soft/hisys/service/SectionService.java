package d3Soft.hisys.service;

import java.util.List;

import d3Soft.hisys.model.Section;


public interface SectionService {

	public void insert(Section section);
	public void update(Section section);
	public void delete(Section section);
	public Section byId(Section section);
	public List<Section> getAll();
}
