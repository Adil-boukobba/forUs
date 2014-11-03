package d3Soft.hisys.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="com_city")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="city_id")
	private int id;
	@Column(name="city_code")
	private int code;
	@Column(name="city_name")
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Region region;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="city")
	private List<HealthCenter> centers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<HealthCenter> getCenters() {
		return centers;
	}

	public void setCenters(List<HealthCenter> centers) {
		this.centers = centers;
	}
	
	
	
}
