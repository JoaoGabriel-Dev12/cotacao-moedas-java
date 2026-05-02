package com.joaogabriel.cotacao_moedas.service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.joaogabriel.cotacao_moedas.response.CotacaoResponse;

@Service
public class CotacaoService {
	
	private final RestTemplate restTemplate;

	public CotacaoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	@SuppressWarnings("unchecked")
	public CotacaoResponse converter(String from, String to, BigDecimal amount) {
		try {
            String fromUpper = from.toUpperCase();
            String toUpper = to.toUpperCase();

            String url = "https://api.frankfurter.dev/v1/latest?from=" + fromUpper + "&to=" + toUpper;
            
            Map<String, Object> result = restTemplate.getForObject(url, Map.class);

            Map<String, Object> rates = (Map<String, Object>) result.get("rates");
            BigDecimal rate = new BigDecimal(rates.get(toUpper).toString());
            BigDecimal converted = amount.multiply(rate);

            CotacaoResponse response = new CotacaoResponse(fromUpper, toUpper, amount, rate, converted);
            
            return response;

        }catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cotação: " + e.getMessage());
        }
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> moedas(){
		try {
			String url = "https://api.frankfurter.dev/v1/currencies";
			Map<String, String> moedas = restTemplate.getForObject(url, Map.class);
			
			return moedas;
		}catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cotação: " + e.getMessage());
        }
	}
}
