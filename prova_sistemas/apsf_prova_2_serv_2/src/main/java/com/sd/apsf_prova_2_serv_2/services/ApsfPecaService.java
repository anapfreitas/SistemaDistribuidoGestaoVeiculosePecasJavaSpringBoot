package com.sd.apsf_prova_2_serv_2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sd.apsf_prova_2_serv_2.models.ApsfPeca;
import com.sd.apsf_prova_2_serv_2.repositories.ApsfPecaRepository;

@Service
public class ApsfPecaService {

	private final ApsfPecaRepository apsfPecaRepository;

	public ApsfPecaService(ApsfPecaRepository apsfPecaRepository) {
		this.apsfPecaRepository = apsfPecaRepository;
	}

	public List<ApsfPeca> getPecas() {
		return apsfPecaRepository.findAll();
	}

	public ApsfPeca getPeca(Long id) {
		return apsfPecaRepository.findById(id).orElseThrow(() -> new RuntimeException("Peça não encontrada!"));
	}

	public ApsfPeca salvarPeca(ApsfPeca peca) {
		return apsfPecaRepository.save(peca);
	}

	public void excluirPeca(Long id) {
		apsfPecaRepository.deleteById(id);
	}
}
