package com.joaogabriel.cotacao_moedas.domain;

import java.io.Serializable;

public class Cotacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String codein;
	private String name;
	private String bid;
	private String ask;
	private String timestamp;
	private String create_date;
	
	public Cotacao() {
		// TODO Auto-generated constructor stub
	}

	public Cotacao(String code, String codein, String name,
			String bid, String ask, String timestamp, String create_date) {
		super();
		this.code = code;
		this.codein = codein;
		this.name = name;
		this.bid = bid;
		this.ask = ask;
		this.timestamp = timestamp;
		this.create_date = create_date;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
}
