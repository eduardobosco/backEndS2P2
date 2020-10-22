package br.com.neki.s2p2backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication

public class S2p2BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(S2p2BackendApplication.class, args);
	}
	
	@RequestMapping("/home")
	public String hello() {
		return "Hello buddy!";
	}

}
