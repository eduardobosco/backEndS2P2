package br.com.neki.s2p2backend.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neki.s2p2backend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
