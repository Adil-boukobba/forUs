package d3Soft.hisys.service;

import java.util.List;

import d3Soft.hisys.model.ArticleFamille;

public interface ArticleFamilleService {

	public void insert(ArticleFamille articlefamile);
	public void update(ArticleFamille articlefamile);
	public void delete(ArticleFamille articlefamile);
	public ArticleFamille byId(int id);
	public List<ArticleFamille> getAll();
}
