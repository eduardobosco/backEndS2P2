package br.com.neki.s2p2backend.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "EVENT")

public class Event implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String title;
	
	private String description;
	
	private String notification;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant initial_Date;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant end_Date;
	
	private String repeat;
	
	private String reason;
	
	private Boolean manager_notification;
	
	
	public Event () {}


	public Event(Integer id, String title, String description, String notification, Instant initial_Date,
			Instant end_Date, String repeat, String reason, Boolean manager_notification) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.notification = notification;
		this.initial_Date = initial_Date;
		this.end_Date = end_Date;
		this.repeat = repeat;
		this.reason = reason;
		this.manager_notification = manager_notification;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getNotification() {
		return notification;
	}


	public void setNotification(String notification) {
		this.notification = notification;
	}


	public Instant getInitial_Date() {
		return initial_Date;
	}


	public void setInitial_Date(Instant initial_Date) {
		this.initial_Date = initial_Date;
	}


	public Instant getEnd_Date() {
		return end_Date;
	}


	public void setEnd_Date(Instant end_Date) {
		this.end_Date = end_Date;
	}


	public String getRepeat() {
		return repeat;
	}


	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public Boolean getManager_notification() {
		return manager_notification;
	}


	public void setManager_notification(Boolean manager_notification) {
		this.manager_notification = manager_notification;
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
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
