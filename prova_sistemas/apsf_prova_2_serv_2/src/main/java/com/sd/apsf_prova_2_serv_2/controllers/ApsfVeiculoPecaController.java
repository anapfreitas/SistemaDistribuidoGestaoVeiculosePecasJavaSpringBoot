package com.sd.apsf_prova_2_serv_2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.apsf_prova_2_serv_2.models.ApsfVeiculoPeca;
import com.sd.apsf_prova_2_serv_2.models.ApsfVeiculoPecaId;
import com.sd.apsf_prova_2_serv_2.services.ApsfVeiculoPecaService;

@RestController
@RequestMapping("/api/veiculo-pecas")
public class ApsfVeiculoPecaController {

	@Autowired
	private ApsfVeiculoPecaService apsfVeiculoPecaService;

	@CrossOrigin(origins = "*")
	@GetMapping
	public List<ApsfVeiculoPeca> getVeiculoPecas() {
		return apsfVeiculoPecaService.getVeiculoPecas();
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	public ApsfVeiculoPeca salvarVeiculoPeca(@RequestBody ApsfVeiculoPeca veiculoPeca) {
		return apsfVeiculoPecaService.salvarVeiculoPeca(veiculoPeca);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping
	public void excluirVeiculoPeca(@RequestBody ApsfVeiculoPecaId id) {
		apsfVeiculoPecaService.excluirVeiculoPeca(id);
	}
}