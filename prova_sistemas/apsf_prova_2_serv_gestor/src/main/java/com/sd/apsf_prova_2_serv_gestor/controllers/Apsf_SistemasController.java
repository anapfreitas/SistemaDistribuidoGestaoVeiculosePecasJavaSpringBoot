package com.sd.apsf_prova_2_serv_gestor.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.apsf_prova_2_serv_gestor.services.Apsf_SistemasService;

@RestController
@RequestMapping("/api/sistemas")
@CrossOrigin(origins = "*")
public class Apsf_SistemasController {

	private final Apsf_SistemasService apsf_SistemasService;

	public Apsf_SistemasController(Apsf_SistemasService apsf_SistemasService) {
		this.apsf_SistemasService = apsf_SistemasService;
	}

	// Serviço 1 - API Veículos
	@GetMapping("/veiculos")
	public ResponseEntity<String> apsf_GetVeiculos() {
		return apsf_SistemasService.apsf_GetVeiculos();
	}

	@PostMapping("/veiculos")
	public ResponseEntity<String> apsf_SalvarVeiculo(@RequestBody String veiculoJson) {
		return apsf_SistemasService.apsf_SalvarVeiculo(veiculoJson);
	}

	@DeleteMapping("/veiculos")
	public ResponseEntity<String> apsf_DeletarVeiculo(@RequestBody String veiculoJson) {
		return apsf_SistemasService.apsf_DeletarVeiculo(veiculoJson);
	}

	// Serviço 2 - API Peças
	@GetMapping("/pecas")
	public ResponseEntity<String> apsf_GetPecas() {
		return apsf_SistemasService.apsf_GetPecas();
	}

	@PostMapping("/pecas")
	public ResponseEntity<String> apsf_SalvarPeca(@RequestBody String pecaJson) {
		return apsf_SistemasService.apsf_SalvarPeca(pecaJson);
	}

	@DeleteMapping("/pecas")
	public ResponseEntity<String> apsf_DeletarPeca(@RequestBody String pecaJson) {
		return apsf_SistemasService.apsf_DeletarPeca(pecaJson);
	}

	// Serviço 2 - API VeículoPecas
	@GetMapping("/veiculo-pecas")
	public ResponseEntity<String> apsf_GetVeiculoPecas() {
		return apsf_SistemasService.apsf_GetVeiculoPecas();
	}

	@PostMapping("/veiculo-pecas")
	public ResponseEntity<String> apsf_SalvarVeiculoPeca(@RequestBody String veiculoPecaJson) {
		return apsf_SistemasService.apsf_SalvarVeiculoPeca(veiculoPecaJson);
	}

	@DeleteMapping("/veiculo-pecas")
	public ResponseEntity<String> apsf_DeletarVeiculoPeca(@RequestBody String veiculoPecaJson) {
		return apsf_SistemasService.apsf_DeletarVeiculoPeca(veiculoPecaJson);
	}
}