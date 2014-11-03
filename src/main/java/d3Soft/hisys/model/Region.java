package d3Soft.hisys.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="com_region")
public class Region {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="region_id")
	private int id;
	@Column(name="region_code")
	private int code;
	@Column(name="region_name")
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="region")
	private List<City> cities;

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

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	
	
}
