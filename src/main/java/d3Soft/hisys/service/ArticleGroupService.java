package d3Soft.hisys.service;

import java.util.List;



import d3Soft.hisys.model.ArticleGroup;


public interface ArticleGroupService {

	public void insert(ArticleGroup group);
	public void update(ArticleGroup group);
	public void delete(ArticleGroup group);
	public ArticleGroup byId(int id);
	public List<ArticleGroup> getAll();
}
