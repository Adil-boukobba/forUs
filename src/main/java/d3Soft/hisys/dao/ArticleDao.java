package d3Soft.hisys.dao;

import java.util.List;

import d3Soft.hisys.model.Article;


public interface ArticleDao {

		public void insert(Article article);
		public void update(Article article);
		public void delete(Article article);
		public Article byId(int id);
		public List<Article> getAll();
}