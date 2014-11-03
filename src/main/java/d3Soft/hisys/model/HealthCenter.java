package d3Soft.hisys.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="com_health_center")
public class HealthCenter {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="health_center_id")
	private int id;
	@Column(name="health_center_name")
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private City city;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="center")
	private List<Hospital> hospitals;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Hospital> getHospitals() {
		return hospitals;
	}

	public void setHospitals(List<Hospital> hospitals) {
		this.hospitals = hospitals;
	}
	
	
	
}
