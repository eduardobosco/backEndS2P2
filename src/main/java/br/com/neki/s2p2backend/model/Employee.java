package br.com.neki.s2p2backend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.neki.s2p2backend.enums.Role;

@Entity
@Table(name = "EMPLOYEE")


public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String c_password;
	
	private Role role;
	
	@ManyToOne()
	@JoinColumn(name="id_departament", referencedColumnName="id")
	private Departament departament;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<Event> event = new ArrayList<>();
	
		
	public Employee () {}
	

	public Employee(Integer id, String name, String c_password, Role role, Departament departament) {
		super();
		this.id = id;
		this.name = name;
		this.c_password = c_password;
		this.role = role;
		this.departament = departament;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getC_password() {
		return c_password;
	}


	public void setC_password(String c_password) {
		this.c_password = c_password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Departament getDepartament() {
		return departament;
	}


	public void setDepartament(Departament departament) {
		this.departament = departament;
	}


	public List<Event> getEvent() {
		return event;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
}