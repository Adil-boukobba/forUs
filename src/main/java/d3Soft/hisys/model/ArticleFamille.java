package d3Soft.hisys.model;

import java.util.List;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="tab_articleFamille")
public class ArticleFamille {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="identifier")
	private int id;
	
	@Column(name="nombre_famille")
	private String nbr;
	
	@Column(name="id_famille")
	private String idFamille;
	
	/************** To get list of group/family in database ****************/
	@OneToMany(fetch=FetchType.LAZY, mappedBy="famille")	
	private List<ArticleGroup> groups;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="famille")
	private List<Article> articles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNbr() {
		return nbr;
	}

	public void setNbr(String nbr) {
		this.nbr = nbr;
	}

	public String getIdFamille() {
		return idFamille;
	}

	public void setIdFamille(String idFamille) {
		this.idFamille = idFamille;
	}

	public List<ArticleGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<ArticleGroup> groups) {
		this.groups = groups;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	 
	
	
}

