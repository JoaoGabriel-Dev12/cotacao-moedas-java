package com.joaogabriel.cotacao_moedas.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.joaogabriel.cotacao_moedas.domain.Cotacao;
import com.joaogabriel.cotacao_moedas.response.CotacaoResponse;

@Service
public class CotacaoService {

	public CotacaoResponse conversao(Cotacao cot, BigDecimal amount) {
		
		BigDecimal bidDecimal = new BigDecimal(cot.getBid());
		
		
		CotacaoResponse response = new CotacaoResponse(cot.getCode(), cot.getCodein(), 
				amount, bidDecimal, amount.multiply(bidDecimal));
		
		return response;
	}
}
