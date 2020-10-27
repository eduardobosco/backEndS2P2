package br.com.neki.s2p2backend.model.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.neki.s2p2backend.model.Event;
import br.com.neki.s2p2backend.model.Notification;

public class EventDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String title;

	private String description;

	private String remember;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", locale = "pt-BR", timezone = "Brazil/East")
	private Instant initial_Date;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", locale = "pt-BR", timezone = "Brazil/East")
	private Instant end_Date;

	private String repeat;

	private String reason;

	private Boolean manager_notification;

	private Notification notification;

	private Integer id_employee;
	
	public EventDTO () {}

	public EventDTO(Integer id, String title, String description, String remember, Instant initial_Date,
			Instant end_Date, String repeat, String reason, Boolean manager_notification, Notification notification,
			Integer id_employee) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.remember = remember;
		this.initial_Date = initial_Date;
		this.end_Date = end_Date;
		this.repeat = repeat;
		this.reason = reason;
		this.manager_notification = manager_notification;
		this.notification = notification;
		this.id_employee = id_employee;
	}

	public EventDTO(Integer id, String title, String description, String remember, Instant initial_Date,
			Instant end_Date, String repeat, String reason, Boolean manager_notification, Integer id_employee) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.remember = remember;
		this.initial_Date = initial_Date;
		this.end_Date = end_Date;
		this.repeat = repeat;
		this.reason = reason;
		this.manager_notification = manager_notification;
		this.id_employee = id_employee;
	}
	
	
	public EventDTO(Event event) {
		super();
		this.id = event.getId();
		this.title = event.getTitle();
		this.description = event.getDescription();
		this.remember = event.getRemember();
		this.initial_Date = event.getInitial_Date();
		this.end_Date = event.getEnd_Date();
		this.repeat = event.getRepeat();
		this.reason = event.getReason();
		this.manager_notification = event.getManager_notification();
//		this.id_employee = id_employee;
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

	public String getRemember() {
		return remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
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

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public Integer getId_employee() {
		return id_employee;
	}

	public void setId_employee(Integer id_employee) {
		this.id_employee = id_employee;
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
		EventDTO other = (EventDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
