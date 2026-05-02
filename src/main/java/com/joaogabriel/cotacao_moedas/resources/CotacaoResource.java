package com.joaogabriel.cotacao_moedas.resources;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joaogabriel.cotacao_moedas.response.CotacaoResponse;
import com.joaogabriel.cotacao_moedas.service.CotacaoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cotacao")
public class CotacaoResource {

	private final CotacaoService service;
	
    public CotacaoResource(CotacaoService service) {
		super();
		this.service = service;
	}

	@GetMapping("/convert")
    public ResponseEntity<?> conversao(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam BigDecimal amount
    ) {
        
		try {
	        CotacaoResponse result = service.converter(from, to, amount);
	        return ResponseEntity.ok().body(result);
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(503).body(Map.of("erro", e.getMessage()));
	    }
    }
    
    @GetMapping("/currencies")
    public ResponseEntity<Map<String, String>> getCurrencies(){
    	Map<String, String> currencies = service.moedas();
    	
    	if(currencies.isEmpty()) {
    		return ResponseEntity.status(503).build();
    	}
    	return ResponseEntity.ok().body(currencies);
    }
}