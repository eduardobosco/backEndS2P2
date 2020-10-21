package br.com.neki.s2p2backend.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.neki.s2p2backend.model.Collaborator;
import br.com.neki.s2p2backend.model.Event;
import br.com.neki.s2p2backend.respository.CollaboratorRepository;
import br.com.neki.s2p2backend.respository.EventRepository;

@Configuration
@Profile("test")

public class TestConfig implements CommandLineRunner {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private CollaboratorRepository collaboratorRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Collaborator c1 = new Collaborator(null, "Eduardo Bosco", "12345");
		Collaborator c2 = new Collaborator(null, "Thayna Muller", "12345");
		Collaborator c3 = new Collaborator(null, "Lucas Braga", "12345");
		
		collaboratorRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		

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
		
		
		
	}

	

}
