package br.com.neki.s2p2backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.s2p2backend.exception.EventNotFoundException;
import br.com.neki.s2p2backend.exception.ParametroObrigatorioException;
import br.com.neki.s2p2backend.model.Employee;
import br.com.neki.s2p2backend.model.Event;
import br.com.neki.s2p2backend.model.Notification;
import br.com.neki.s2p2backend.model.dto.EventDTO;
import br.com.neki.s2p2backend.respository.EmployeeRepository;
import br.com.neki.s2p2backend.respository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Event inserir(EventDTO eventDTO) {
		Event event = new Event();
		copyDTOtoEntity(eventDTO, event);
		
		Event eventSalvoNoBd = eventRepository.save(event);
		return eventSalvoNoBd;
	}

	private void copyDTOtoEntity(EventDTO eventDTO, Event event) {
		event.setTitle(eventDTO.getTitle());
		event.setDescription(eventDTO.getDescription());
		event.setRemember(eventDTO.getRemember());
		event.setInitial_Date(eventDTO.getInitial_Date());
		event.setEnd_Date(eventDTO.getEnd_Date());
		event.setRepeat(eventDTO.getRepeat());
		event.setReason(eventDTO.getReason());
		event.setManager_notification(eventDTO.getManager_notification());
		
		Employee employee = employeeRepository.getOne(eventDTO.getId_employee());
		
		event.setEmployee(employee);
		if(eventDTO.getManager_notification()) {
			Notification notifications = new Notification(null,"","Pendente", event);
			event.setNotification(notifications);
			System.out.println("oi");
		}
	}

	public List<Event> listar() {
		return eventRepository.findAll();
	}

	public Event listarPorId(Integer id) throws EventNotFoundException {
		Optional<Event> optionalEvent = eventRepository.findById(id);

		if (optionalEvent.isPresent()) {
			return optionalEvent.get();
		}
		throw new EventNotFoundException("Event com id " + id + " não encontrada");
	}

	public Event substituir(Integer id, Event event, EventDTO eventDTO)
			throws ParametroObrigatorioException, EventNotFoundException {
		if (event == null)
			throw new ParametroObrigatorioException("Campo 'event' é obrigatório");

		Event eventNoBanco = listarPorId(id);

		if (event.getTitle() != null) {
			eventNoBanco.setTitle(event.getTitle());
		}

		if (event.getDescription() != null) {
			eventNoBanco.setDescription(event.getDescription());
		}
		
		if (event.getRemember() != null) {
			eventNoBanco.setRemember(event.getRemember());
		}
		
		if (event.getInitial_Date() != null) {
			eventNoBanco.setInitial_Date(event.getInitial_Date());
		}
		if (event.getEnd_Date() != null) {
			eventNoBanco.setEnd_Date(event.getEnd_Date());
		}
		if (event.getRepeat() != null) {
			eventNoBanco.setRepeat(event.getRepeat());
		}
		if (event.getReason() != null) {
			eventNoBanco.setReason(event.getReason());
		}
		if (event.getManager_notification() != null) {
			eventNoBanco.setManager_notification(event.getManager_notification());
		}
		if (eventDTO.getManager_notification()) {
			copyDTOtoEntity(eventDTO, event);
		}

		return eventRepository.save(eventNoBanco);
	}

	public void deletar(Integer id) throws EventNotFoundException {
		Event eventNoBanco = listarPorId(id);
		eventRepository.delete(eventNoBanco);
	}

	public List<Event> listarPorKey(Integer key) {
		List<Event> events = eventRepository.events(key);
		return events;
	}

	public List<Event> listarPorNotifications(Integer key) {
		List<Event> events = eventRepository.notifications(key);
		return events;
	}
}
