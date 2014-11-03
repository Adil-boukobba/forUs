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
}
