package br.com.neki.s2p2backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.s2p2backend.exception.EventNotFoundException;
import br.com.neki.s2p2backend.exception.ParametroObrigatorioException;
import br.com.neki.s2p2backend.model.Event;
import br.com.neki.s2p2backend.model.dto.EventDTO;
import br.com.neki.s2p2backend.service.EventService;

@RestController
@RequestMapping("/event")

public class EventController {

	@Autowired
	private EventService eventService;

	@PostMapping
	public ResponseEntity<Void> inserir(@Valid @RequestBody EventDTO event) {
		eventService.inserir(event);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Event>> listar() {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(eventService.listar(), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Event> listarPorId(@PathVariable Integer id) throws EventNotFoundException {
		Event event = eventService.listarPorId(id);

		if (event != null) {
			return ResponseEntity.ok(event);
		}
		return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> substituir(@PathVariable Integer id, @RequestBody(required = true) Event event)
			throws EventNotFoundException, ParametroObrigatorioException {
		eventService.substituir(id, event);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) throws EventNotFoundException {
		eventService.deletar(id);
	}

}
