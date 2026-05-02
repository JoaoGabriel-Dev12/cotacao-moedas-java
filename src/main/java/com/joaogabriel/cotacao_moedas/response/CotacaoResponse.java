package com.joaogabriel.cotacao_moedas.response;

import java.io.Serializable;
import java.math.BigDecimal;

public class CotacaoResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String from;
	private String to;
	private BigDecimal amount;
	private BigDecimal rate;
	private BigDecimal result;
	
	public CotacaoResponse() {
		// TODO Auto-generated constructor stub
	}

	public CotacaoResponse(String from, String to, BigDecimal amount, BigDecimal rate, BigDecimal result) {
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.rate = rate;
		this.result = result;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}
}
