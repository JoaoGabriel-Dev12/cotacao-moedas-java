package com.joaogabriel.cotacao_moedas.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthResource {

	@GetMapping("/health")
	public ResponseEntity<String> health(){
		return ResponseEntity.ok("ok");
	}
}
