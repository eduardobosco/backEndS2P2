package br.com.neki.s2p2backend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "NOTIFICATION")


public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
		
	private String manager_Comment;
	
	private String notification_Status;
	
	@ManyToOne()
	@JoinColumn(name="id_employee")
	private Employee employee;
	
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Event event;
	
	
	public Notification() {
		
	}
	
	public Notification(Integer id, String manager_Comment, String notification_Status
			) {
		super();
		this.id = id;
		this.manager_Comment = manager_Comment;
		this.notification_Status = notification_Status;
	}

	public Notification(Integer id, String manager_Comment, String notification_Status, Event event, Employee employee 
			) {
		super();
		this.id = id;
		this.manager_Comment = manager_Comment;
		this.notification_Status = notification_Status;
		this.event = event;
		this.employee = employee;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManager_Comment() {
		return manager_Comment;
	}

	public void setManager_Comment(String manager_Comment) {
		this.manager_Comment = manager_Comment;
	}

	public String getNotification_Status() {
		return notification_Status;
	}

	public void setNotification_Status(String notification_Status) {
		this.notification_Status = notification_Status;
	}

	public Event getEvent() {
		return event;
	}


	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
		Notification other = (Notification) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
