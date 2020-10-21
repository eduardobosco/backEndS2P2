package br.com.neki.s2p2backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.s2p2backend.exception.EmployeeNotFoundException;
import br.com.neki.s2p2backend.exception.ParametroObrigatorioException;
import br.com.neki.s2p2backend.model.Employee;
import br.com.neki.s2p2backend.respository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee inserir(Employee employee) {
		Employee employeeSalvoNoBd = employeeRepository.save(employee);
		return employeeSalvoNoBd;

	}

	public List<Employee> listar() {
		return employeeRepository.findAll();
	}

	public Employee listarPorId(Integer id) throws EmployeeNotFoundException {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);

		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}
		throw new EmployeeNotFoundException("Employee com id " + id + " não encontrada");
	}

	public Employee substituir(Integer id, Employee employee)
			throws ParametroObrigatorioException, EmployeeNotFoundException {
		if (employee == null)
			throw new ParametroObrigatorioException("Campo 'employee' é obrigatório");

		Employee employeeNoBanco = listarPorId(id);

		if (employee.getNome() != null) {
			employeeNoBanco.setNome(employee.getNome());
		}

		if (employee.getC_password() != null) {
			employeeNoBanco.setC_password(employee.getC_password());
		}
		
		return employeeRepository.save(employeeNoBanco);
	}

	public void deletar(Integer id) throws EmployeeNotFoundException {
		Employee employeeNoBanco = listarPorId(id);
		employeeRepository.delete(employeeNoBanco);
	}

	
}
