package com.sd.apsf_prova_2_serv_1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sd.apsf_prova_2_serv_1.models.ApsfVeiculo;
import com.sd.apsf_prova_2_serv_1.services.ApsfVeiculoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "*")
public class ApsfVeiculoController {

	@Autowired
	private ApsfVeiculoService apsfVeiculoService;

	@CrossOrigin(origins = "*")
	@GetMapping
	public List<ApsfVeiculo> getVeiculos() {
		return apsfVeiculoService.getVeiculos();
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	public ApsfVeiculo salvarVeiculo(@RequestBody ApsfVeiculo veiculo) {
		return apsfVeiculoService.salvarVeiculo(veiculo);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping
	public void deletarVeiculo(@RequestBody ApsfVeiculo veiculo) {
		apsfVeiculoService.excluirVeiculo(veiculo.getApsf_IdVeiculo());
	}
}
