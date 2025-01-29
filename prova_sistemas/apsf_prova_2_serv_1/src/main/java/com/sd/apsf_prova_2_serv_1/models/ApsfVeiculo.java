package com.sd.apsf_prova_2_serv_1.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculo")
public class ApsfVeiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long apsf_IdVeiculo;

	@Column(nullable = false)
	private String apsf_Nome;

	@Column(nullable = false)
	private String apsf_Modelo;

	@Column(nullable = false)
	private String apsf_Marca;

	@Column(nullable = false)
	private Integer apsf_Ano;

	public Long getApsf_IdVeiculo() {
		return apsf_IdVeiculo;
	}

	public void setApsf_IdVeiculo(Long apsf_IdVeiculo) {
		this.apsf_IdVeiculo = apsf_IdVeiculo;
	}

	public String getApsf_Nome() {
		return apsf_Nome;
	}

	public void setApsf_Nome(String apsf_Nome) {
		this.apsf_Nome = apsf_Nome;
	}

	public String getApsf_Modelo() {
		return apsf_Modelo;
	}

	public void setApsf_Modelo(String apsf_Modelo) {
		this.apsf_Modelo = apsf_Modelo;
	}

	public String getApsf_Marca() {
		return apsf_Marca;
	}

	public void setApsf_Marca(String apsf_Marca) {
		this.apsf_Marca = apsf_Marca;
	}

	public Integer getApsf_Ano() {
		return apsf_Ano;
	}

	public void setApsf_Ano(Integer apsf_Ano) {
		this.apsf_Ano = apsf_Ano;
	}
}