package com.sd.apsf_prova_2_serv_2.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sd.apsf_prova_2_serv_2.models.ApsfVeiculoPeca;
import com.sd.apsf_prova_2_serv_2.models.ApsfVeiculoPecaId;
import com.sd.apsf_prova_2_serv_2.repositories.ApsfVeiculoPecaRepository;

@Service
public class ApsfVeiculoPecaService {

	private final ApsfVeiculoPecaRepository apsfVeiculoPecaRepository;

	public ApsfVeiculoPecaService(ApsfVeiculoPecaRepository apsfVeiculoPecaRepository) {
		this.apsfVeiculoPecaRepository = apsfVeiculoPecaRepository;
	}

	public List<ApsfVeiculoPeca> getVeiculoPecas() {
		return apsfVeiculoPecaRepository.findAll();
	}

	public ApsfVeiculoPeca salvarVeiculoPeca(ApsfVeiculoPeca veiculoPeca) {
		return apsfVeiculoPecaRepository.save(veiculoPeca);
	}

	public void excluirVeiculoPeca(ApsfVeiculoPecaId id) {
		apsfVeiculoPecaRepository.deleteById(id);
	}
}