package d3Soft.hisys.dao;

import java.util.List;


import d3Soft.hisys.model.ArticleGroup;

public interface ArticleGroupDao {

	public void insert(ArticleGroup group);
	public void update(ArticleGroup group);
	public void delete(ArticleGroup group);
	public ArticleGroup byId(int id);
	public List<ArticleGroup> getAll();
}
