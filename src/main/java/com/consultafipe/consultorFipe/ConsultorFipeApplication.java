package com.consultafipe.consultorFipe;

import com.consultafipe.consultorFipe.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultorFipeApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(ConsultorFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.exibirMenu();
	}
}
