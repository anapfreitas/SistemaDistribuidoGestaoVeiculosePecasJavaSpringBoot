package com.sd.apsf_prova_2_serv_1.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sd.apsf_prova_2_serv_1.models.ApsfVeiculo;
import com.sd.apsf_prova_2_serv_1.repositories.ApsfVeiculoRepository;

@Service
public class ApsfVeiculoService {

	private final ApsfVeiculoRepository apsfVeiculoRepository;

	public ApsfVeiculoService(ApsfVeiculoRepository apsfVeiculoRepository) {
		this.apsfVeiculoRepository = apsfVeiculoRepository;
	}

	public List<ApsfVeiculo> getVeiculos() {
		return apsfVeiculoRepository.findAll();
	}

	public ApsfVeiculo getVeiculo(Long id) {
		return apsfVeiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Veículo não encontrado!"));
	}

	public ApsfVeiculo salvarVeiculo(ApsfVeiculo veiculo) {
		return apsfVeiculoRepository.save(veiculo);
	}

	public void excluirVeiculo(Long id) {
		apsfVeiculoRepository.deleteById(id);
	}
}