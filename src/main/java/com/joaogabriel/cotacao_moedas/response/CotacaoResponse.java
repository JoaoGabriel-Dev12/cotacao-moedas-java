package com.joaogabriel.cotacao_moedas.response;

import java.math.BigDecimal;

public class CotacaoResponse {

	private String code;
	private String codein;
	private BigDecimal amount;
	private BigDecimal bid;
	private BigDecimal convert_amount;
	
	public CotacaoResponse() {
		// TODO Auto-generated constructor stub
	}

	public CotacaoResponse(String code, String codein, BigDecimal amount, BigDecimal bid, BigDecimal convert_amount) {
		super();
		this.code = code;
		this.codein = codein;
		this.amount = amount;
		this.bid = bid;
		this.convert_amount = convert_amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodein() {
		return codein;
	}

	public void setCodein(String codein) {
		this.codein = codein;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBid() {
		return bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public BigDecimal getConvert_amount() {
		return convert_amount;
	}

	public void setConvert_amount(BigDecimal convert_amount) {
		this.convert_amount = convert_amount;
	}
	
	
}
