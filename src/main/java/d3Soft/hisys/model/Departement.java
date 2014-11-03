package d3Soft.hisys.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="com_department")
public class Departement {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="department_id")
	private int id;
	@Column(name="department_code")
	private int code;
	@Column(name="department_name")
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Hospital hospital;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
	private List<Section> sections;
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
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	
}
