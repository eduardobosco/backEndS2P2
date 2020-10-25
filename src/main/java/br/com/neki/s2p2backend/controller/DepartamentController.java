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

import br.com.neki.s2p2backend.exception.DepartamentNotFoundException;
import br.com.neki.s2p2backend.exception.ParametroObrigatorioException;
import br.com.neki.s2p2backend.model.Departament;
import br.com.neki.s2p2backend.service.DepartamentService;

@RestController
@RequestMapping("/departament")

public class DepartamentController {

	@Autowired
	private DepartamentService departamentService;

	@PostMapping
	public ResponseEntity<Void> inserir(@Valid @RequestBody Departament departament) {
		departamentService.inserir(departament);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Departament>> listar() {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(departamentService.listar(), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departament> listarPorId(@PathVariable Integer id) throws DepartamentNotFoundException {
		Departament departament = departamentService.listarPorId(id);

		if (departament != null) {
			return ResponseEntity.ok(departament);
		}
		return new ResponseEntity<Departament>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> substituir(@PathVariable Integer id, @RequestBody(required = true) Departament departament)
			throws DepartamentNotFoundException, ParametroObrigatorioException {
		departamentService.substituir(id, departament);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) throws DepartamentNotFoundException {
		departamentService.deletar(id);
	}

}
