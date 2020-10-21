package br.com.neki.s2p2backend.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.neki.s2p2backend.enums.Role;
import br.com.neki.s2p2backend.model.Departament;
import br.com.neki.s2p2backend.model.Employee;
import br.com.neki.s2p2backend.model.Event;
import br.com.neki.s2p2backend.model.Notification;
import br.com.neki.s2p2backend.respository.DepartamentRepository;
import br.com.neki.s2p2backend.respository.EmployeeRepository;
import br.com.neki.s2p2backend.respository.EventRepository;
import br.com.neki.s2p2backend.respository.NotificationRepository;

@Configuration
@Profile("test")

public class TestConfig implements CommandLineRunner {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private DepartamentRepository departamentRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Departament d1 = new Departament(null, "financeiro");
		Departament d2 = new Departament(null, "comercial");
		Departament d3 = new Departament(null, "desenvolvimento");
		
		
		departamentRepository.saveAll(Arrays.asList(d1, d2, d3));
		
		
		
		Employee c1 = new Employee(null, "Eduardo Bosco", "12345", Role.USER, d1);
		Employee c2 = new Employee(null, "Thayna Muller", "12345", Role.GESTOR, d2);
		Employee c3 = new Employee(null, "Lucas Braga", "12345", Role.USER, d3);
		
		employeeRepository.saveAll(Arrays.asList(c1, c2, c3));
		

		Event ev1 = new Event(null, "Evento1", "Testanto Evento1", "Dia Anterior",
				Instant.parse("2020-10-20T18:00:07Z"), Instant.parse("2020-10-20T20:00:07Z"), "Nunca", "Trabalho",
				false, c1);
		Event ev2 = new Event(null, "Evento2", "Testanto Evento1", "Dia Anterior",
				Instant.parse("2020-10-21T18:00:07Z"), Instant.parse("2020-10-20T20:00:07Z"), "Nunca", "Trabalho",
				false, c2);
		Event ev3 = new Event(null, "Evento3", "Testanto Evento1", "Dia Anterior",
				Instant.parse("2020-10-22T18:00:07Z"), Instant.parse("2020-10-20T20:00:07Z"), "Nunca", "Trabalho",
				false, c3);
		Event ev4 = new Event(null, "Evento4", "Testanto Evento1", "Dia Anterior",
				Instant.parse("2020-10-23T18:00:07Z"), Instant.parse("2020-10-20T20:00:07Z"), "Nunca", "Trabalho",
				false, c1);
		Event ev5 = new Event(null, "Evento5", "Testanto Evento1", "Dia Anterior",
				Instant.parse("2020-10-24T18:00:07Z"), Instant.parse("2020-10-20T20:00:07Z"), "Nunca", "Trabalho",
				false, c2);

		eventRepository.saveAll(Arrays.asList(ev1, ev2, ev3, ev4, ev5));
		
		Notification n1 = new Notification(null, "observações do gestor", "verificada", ev1, c1);
		
		notificationRepository.saveAll(Arrays.asList(n1));
		
		
		
	}

	

}
