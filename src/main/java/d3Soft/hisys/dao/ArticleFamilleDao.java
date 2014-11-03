package d3Soft.hisys.dao;

import java.util.List;


import d3Soft.hisys.model.ArticleFamille;

public interface ArticleFamilleDao {

	
	public void insert(ArticleFamille articlefamile);
	public void update(ArticleFamille articlefamile);
	public void delete(ArticleFamille articlefamile);
	public ArticleFamille byId(int id);
	public List<ArticleFamille> getAll();
}
