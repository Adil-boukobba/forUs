package d3Soft.hisys.service;

import java.util.List;

import d3Soft.hisys.model.Article;

public interface ArticleService {

	public void insert(Article article);
	public void update(Article article);
	public void delete(Article article);
	public Article byId(Article article);
	public List<Article> getAll();
}
