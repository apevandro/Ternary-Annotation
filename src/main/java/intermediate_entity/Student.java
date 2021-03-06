package intermediate_entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@Column(name = "StudentId")
	private int studentId;
	
	@Column(name = "Name")
	private String name;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "student")
	private Set<UniClass> uniClasses = new HashSet<UniClass>();
	
	public Student() {}
	
	public Student(int studentId, String name, Address address) {
		this.studentId = studentId;
		this.name = name;
		this.address = address;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<UniClass> getUniClasses() {
		return uniClasses;
	}

	public void setUniClasses(Set<UniClass> uniClasses) {
		this.uniClasses = uniClasses;
	}

}