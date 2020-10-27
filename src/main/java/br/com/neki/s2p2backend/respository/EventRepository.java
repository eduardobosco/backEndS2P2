package br.com.neki.s2p2backend.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.neki.s2p2backend.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
	
	@Query(value="SELECT * FROM EVENT WHERE ID_EMPLOYEE = :id_employee", nativeQuery=true)
	List<Event> events(Integer id_employee);

}
