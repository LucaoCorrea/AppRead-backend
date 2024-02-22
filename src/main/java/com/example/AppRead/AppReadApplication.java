package com.example.AppRead;

import com.example.AppRead.auth.AuthenticationRequest;
import com.example.AppRead.auth.AuthenticationService;
import com.example.AppRead.auth.RegisterRequest;
import com.example.AppRead.book.BookRequest;
import com.example.AppRead.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;

import static com.example.AppRead.user.Role.ADMIN;
import static com.example.AppRead.user.Role.MANAGER;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AppReadApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppReadApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Lucas")
					.lastname("Corrêa")
					.email("admin@gmail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());


			var manager = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("manager@gmail.com")
					.password("password")
					.role(MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());
		};
	}

}