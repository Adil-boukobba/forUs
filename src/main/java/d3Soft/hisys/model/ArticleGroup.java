package d3Soft.hisys.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tab_ArticleGroup")
public class ArticleGroup {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="identifier")
	private int  id;
	
	@Column(name="group_id")
	private String idGroup;
	
	@Column(name="nombre_group")
	private String nbr;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="famille_id", nullable=true)
	private ArticleFamille famille;
	
	/*----- Article list-------*/
	@OneToMany(fetch=FetchType.LAZY, mappedBy="group")
	private List<Article> articles;
	
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(String idGroup) {
		this.idGroup = idGroup;
	}
	public String getNbr() {
		return nbr;
	}
	public void setNbr(String nbr) {
		this.nbr = nbr;
	}
	public ArticleFamille getFamille() {
		return famille;
	}
	public void setFamille(ArticleFamille famille) {
		this.famille = famille;
	}
	
	
	
}
