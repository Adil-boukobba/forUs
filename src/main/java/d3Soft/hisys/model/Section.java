package d3Soft.hisys.model;

import javax.persistence.*;

@Entity
@Table(name="com_section")
public class Section {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="section_id")
	private int id;
	@Column(name="section_code")
	private int code;
	@Column(name="section_name")
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="department_id")
	private Departement department;

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

	public Departement getDepartment() {
		return department;
	}

	public void setDepartment(Departement department) {
		this.department = department;
	}
	
	
	
	
}
