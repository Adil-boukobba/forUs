package d3Soft.hisys.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="com_hospital")
public class Hospital {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="hospital_id")
	private int id;
	@Column(name="hospital_address")
	private String address;
	@Column(name="hospital_name")
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private HealthCenter center;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="hospital")
	private List<Departement> departements;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HealthCenter getCenter() {
		return center;
	}
	public void setCenter(HealthCenter center) {
		this.center = center;
	}
	public List<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	
	
	
}
