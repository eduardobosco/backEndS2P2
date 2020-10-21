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

import br.com.neki.s2p2backend.exception.EmployeeNotFoundException;
import br.com.neki.s2p2backend.exception.ParametroObrigatorioException;
import br.com.neki.s2p2backend.model.Employee;
import br.com.neki.s2p2backend.service.EmployeeService;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<Void> inserir(@Valid @RequestBody Employee employee) {
		employeeService.inserir(employee);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> listar() {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(employeeService.listar(), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> listarPorId(@PathVariable Integer id) throws EmployeeNotFoundException {
		Employee employee = employeeService.listarPorId(id);

		if (employee != null) {
			return ResponseEntity.ok(employee);
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> substituir(@PathVariable Integer id, @RequestBody(required = true) Employee employee)
			throws EmployeeNotFoundException, ParametroObrigatorioException {
		employeeService.substituir(id, employee);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) throws EmployeeNotFoundException {
		employeeService.deletar(id);
	}

}
