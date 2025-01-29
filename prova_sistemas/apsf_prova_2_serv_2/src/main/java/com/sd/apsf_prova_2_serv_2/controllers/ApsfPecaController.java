package com.sd.apsf_prova_2_serv_2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.apsf_prova_2_serv_2.models.ApsfPeca;
import com.sd.apsf_prova_2_serv_2.services.ApsfPecaService;

@RestController
@RequestMapping("/api/pecas")
public class ApsfPecaController {

	@Autowired
	private ApsfPecaService apsfPecaService;

	@CrossOrigin(origins = "*")
	@GetMapping
	public List<ApsfPeca> getPecas() {
		return apsfPecaService.getPecas();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/{id}")
	public ApsfPeca getPeca(@PathVariable Long id) {
		return apsfPecaService.getPeca(id);
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	public ApsfPeca salvarPeca(@RequestBody ApsfPeca peca) {
		return apsfPecaService.salvarPeca(peca);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping
	public void excluirPeca(@RequestBody ApsfPeca peca) {
		apsfPecaService.excluirPeca(peca.getApsf_IdPeca());
	}
}