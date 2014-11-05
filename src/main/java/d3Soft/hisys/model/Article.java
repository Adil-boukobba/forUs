package d3Soft.hisys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tab_Article")
public class Article {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="identifier")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="famille_id", nullable=true)
	private ArticleFamille famille;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="group_id", nullable=true)
	private ArticleGroup group;
	
	@Column(name="id_article")
	private int idArticle;
	
	@Column(name="nombre_article")
	private String libelle;
	
	@Column(name="validfrom")
	private int validfrom;
	
	@Column(name="validto", nullable=true)
	private int validto;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(String id) {
		this.id = Integer.valueOf(id);
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getValidfrom() {
		return validfrom;
	}
	public void setValidfrom(int validfrom) {
		this.validfrom = validfrom;
	}
	public int getValidto() {
		return validto;
	}
	public void setValidto(int validto) {
		this.validto = validto;
	}
	
	
	public ArticleFamille getFamille() {
		return famille;
	}
	public void setFamille(ArticleFamille famille) {
		this.famille = famille;
	}
	public ArticleGroup getGroup() {
		return group;
	}
	public void setGroup(ArticleGroup group) {
		this.group = group;
	}
	
	
}