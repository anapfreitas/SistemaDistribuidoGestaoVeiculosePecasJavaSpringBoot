package com.sd.apsf_prova_2_serv_2.models;

import java.io.Serializable;
import java.util.Objects;

public class ApsfVeiculoPecaId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long apsf_IdPeca;
	private Long apsf_IdVeiculo;

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ApsfVeiculoPecaId that = (ApsfVeiculoPecaId) o;
		return Objects.equals(apsf_IdPeca, that.apsf_IdPeca) && Objects.equals(apsf_IdVeiculo, that.apsf_IdVeiculo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(apsf_IdPeca, apsf_IdVeiculo);
	}
}