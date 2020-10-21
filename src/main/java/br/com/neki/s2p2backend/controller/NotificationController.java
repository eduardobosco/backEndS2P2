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

import br.com.neki.s2p2backend.exception.NotificationNotFoundException;
import br.com.neki.s2p2backend.exception.ParametroObrigatorioException;
import br.com.neki.s2p2backend.model.Notification;
import br.com.neki.s2p2backend.service.NotificationService;

@RestController
@RequestMapping("/notification")

public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@PostMapping
	public ResponseEntity<Void> inserir(@Valid @RequestBody Notification notification) {
		notificationService.inserir(notification);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Notification>> listar() {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(notificationService.listar(), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Notification> listarPorId(@PathVariable Integer id) throws NotificationNotFoundException {
		Notification notification = notificationService.listarPorId(id);

		if (notification != null) {
			return ResponseEntity.ok(notification);
		}
		return new ResponseEntity<Notification>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> substituir(@PathVariable Integer id, @RequestBody(required = true) Notification notification)
			throws NotificationNotFoundException, ParametroObrigatorioException {
		notificationService.substituir(id, notification);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) throws NotificationNotFoundException {
		notificationService.deletar(id);
	}

}
