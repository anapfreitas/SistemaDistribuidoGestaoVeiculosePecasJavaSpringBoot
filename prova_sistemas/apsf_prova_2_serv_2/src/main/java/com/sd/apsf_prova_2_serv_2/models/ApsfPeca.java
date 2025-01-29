package com.sd.apsf_prova_2_serv_2.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "peca")
public class ApsfPeca implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long apsf_IdPeca;

	@Column(nullable = false)
	private String apsf_Nome;

	@Column(nullable = false)
	private String apsf_Descricao;

	@Column(nullable = false)
	private Double apsf_Altura;

	@Column(nullable = false)
	private Double apsf_Largura;

	@Column(nullable = false)
	private Double apsf_Profundidade;

	@Column(nullable = false)
	private String apsf_MaterialFabricacao;

	@Column(nullable = false)
	private String apsf_LocalVeiculo;

	public Long getApsf_IdPeca() {
		return apsf_IdPeca;
	}

	public void setApsf_IdPeca(Long apsf_IdPeca) {
		this.apsf_IdPeca = apsf_IdPeca;
	}

	public String getApsf_Nome() {
		return apsf_Nome;
	}

	public void setApsf_Nome(String apsf_Nome) {
		this.apsf_Nome = apsf_Nome;
	}

	public String getApsf_Descricao() {
		return apsf_Descricao;
	}

	public void setApsf_Descricao(String apsf_Descricao) {
		this.apsf_Descricao = apsf_Descricao;
	}

	public Double getApsf_Altura() {
		return apsf_Altura;
	}

	public void setApsf_Altura(Double apsf_Altura) {
		this.apsf_Altura = apsf_Altura;
	}

	public Double getApsf_Largura() {
		return apsf_Largura;
	}

	public void setApsf_Largura(Double apsf_Largura) {
		this.apsf_Largura = apsf_Largura;
	}

	public Double getApsf_Profundidade() {
		return apsf_Profundidade;
	}

	public void setApsf_Profundidade(Double apsf_Profundidade) {
		this.apsf_Profundidade = apsf_Profundidade;
	}

	public String getApsf_MaterialFabricacao() {
		return apsf_MaterialFabricacao;
	}

	public void setApsf_MaterialFabricacao(String apsf_MaterialFabricacao) {
		this.apsf_MaterialFabricacao = apsf_MaterialFabricacao;
	}

	public String getApsf_LocalVeiculo() {
		return apsf_LocalVeiculo;
	}

	public void setApsf_LocalVeiculo(String apsf_LocalVeiculo) {
		this.apsf_LocalVeiculo = apsf_LocalVeiculo;
	}

}