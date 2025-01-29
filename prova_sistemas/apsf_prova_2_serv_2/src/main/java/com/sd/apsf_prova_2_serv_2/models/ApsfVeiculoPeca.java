package com.sd.apsf_prova_2_serv_2.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculo_peca")
@IdClass(ApsfVeiculoPecaId.class)
public class ApsfVeiculoPeca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idpeca", nullable = false)
	private Long apsf_IdPeca;

	@Id
	@Column(name = "idveiculo", nullable = false)
	private Long apsf_IdVeiculo;

	@Column(nullable = false)
	private String apsf_Quantidade;

	public Long getApsf_IdPeca() {
		return apsf_IdPeca;
	}

	public void setApsf_IdPeca(Long apsf_IdPeca) {
		this.apsf_IdPeca = apsf_IdPeca;
	}

	public Long getApsf_IdVeiculo() {
		return apsf_IdVeiculo;
	}

	public void setApsf_IdVeiculo(Long apsf_IdVeiculo) {
		this.apsf_IdVeiculo = apsf_IdVeiculo;
	}

	public String getApsf_Quantidade() {
		return apsf_Quantidade;
	}

	public void setApsf_Quantidade(String apsf_Quantidade) {
		this.apsf_Quantidade = apsf_Quantidade;
	}
}