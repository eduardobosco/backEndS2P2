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

import br.com.neki.s2p2backend.exception.CollaboratorNotFoundException;
import br.com.neki.s2p2backend.exception.ParametroObrigatorioException;
import br.com.neki.s2p2backend.model.Collaborator;
import br.com.neki.s2p2backend.service.CollaboratorService;

@RestController
@RequestMapping("/collaborator")

public class CollaboratorController {

	@Autowired
	private CollaboratorService collaboratorService;

	@PostMapping
	public ResponseEntity<Void> inserir(@Valid @RequestBody Collaborator collaborator) {
		collaboratorService.inserir(collaborator);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Collaborator>> listar() {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(collaboratorService.listar(), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Collaborator> listarPorId(@PathVariable Integer id) throws CollaboratorNotFoundException {
		Collaborator collaborator = collaboratorService.listarPorId(id);

		if (collaborator != null) {
			return ResponseEntity.ok(collaborator);
		}
		return new ResponseEntity<Collaborator>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> substituir(@PathVariable Integer id, @RequestBody(required = true) Collaborator collaborator)
			throws CollaboratorNotFoundException, ParametroObrigatorioException {
		collaboratorService.substituir(id, collaborator);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) throws CollaboratorNotFoundException {
		collaboratorService.deletar(id);
	}

}
