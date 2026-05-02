package com.joaogabriel.cotacao_moedas.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.joaogabriel.cotacao_moedas.domain.Cotacao;
import com.joaogabriel.cotacao_moedas.response.CotacaoResponse;

@Service
public class CotacaoService {
	
	private final RestTemplate restTemplate;

	public CotacaoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public CotacaoResponse conversao(Cotacao cot, BigDecimal amount) {
		
		BigDecimal bidDecimal = new BigDecimal(cot.getBid());
		
		
		CotacaoResponse response = new CotacaoResponse(cot.getCode(), cot.getCodein(), 
				amount, bidDecimal, amount.multiply(bidDecimal));
		
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> moedas(){
		try {
			String url = "https://api.frankfurter.dev/v1/currencies";
			Map<String, String> moedas = restTemplate.getForObject(url, Map.class);
			
			return moedas;
		}catch(Exception e) {
			e.printStackTrace();
			return Collections.emptyMap();
		}
	}
}
