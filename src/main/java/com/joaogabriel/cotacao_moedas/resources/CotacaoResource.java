package com.joaogabriel.cotacao_moedas.resources;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.joaogabriel.cotacao_moedas.domain.Cotacao;
import com.joaogabriel.cotacao_moedas.response.CotacaoResponse;
import com.joaogabriel.cotacao_moedas.service.CotacaoService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cotacao")
public class CotacaoResource {

	private final CotacaoService service;
	
	WebClient webClient = WebClient.builder()
	        .baseUrl("https://economia.awesomeapi.com.br")
	        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	        .build();

	public CotacaoResource(CotacaoService service) {
		this.service = service;
	}
	
	@GetMapping("/convert")
	public ResponseEntity<CotacaoResponse> conversao(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount) {
		
		String path = from+"-"+to;
		
		Mono<Map<String, Cotacao>> userMono = webClient.get()
		        .uri("/json/last/" + path) 
		        .retrieve()
		        .bodyToMono(new ParameterizedTypeReference<Map<String, Cotacao>>() {});

		Map<String, Cotacao> map = userMono.block();
		
		Cotacao cotacao = map.get(from + to); 

		CotacaoResponse response = service.conversao(cotacao, amount);
		
		return ResponseEntity.ok().body(response);
	}
}
