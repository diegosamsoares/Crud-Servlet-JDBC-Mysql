package br.triadworks.javaweb.modelo;

import java.util.Calendar;

public class Caloteiro {
	private Long id;
	private String nome;
	private String email;
	private double devendo;
	private Calendar dataDivida;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	public double getDevendo() {
		return devendo;
	}
	public void setDevendo(double devendo) {
		this.devendo = devendo;
	}
	public Calendar getDataDivida() {
		return dataDivida;
	}
	public void setDataDivida(Calendar dataDivida) {
		this.dataDivida = dataDivida;
	}

}
