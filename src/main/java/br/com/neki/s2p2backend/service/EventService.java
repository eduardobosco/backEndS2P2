package br.com.neki.s2p2backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.s2p2backend.exception.EventNotFoundException;
import br.com.neki.s2p2backend.exception.ParametroObrigatorioException;
import br.com.neki.s2p2backend.model.Event;
import br.com.neki.s2p2backend.respository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	public Event inserir(Event event) {
		Event eventSalvoNoBd = eventRepository.save(event);
		return eventSalvoNoBd;

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

	public Event substituir(Integer id, Event event)
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
		
		if (event.getNotification() != null) {
			eventNoBanco.setNotification(event.getNotification());
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

		return eventRepository.save(eventNoBanco);
	}

	public void deletar(Integer id) throws EventNotFoundException {
		Event eventNoBanco = listarPorId(id);
		eventRepository.delete(eventNoBanco);
	}

	
}
