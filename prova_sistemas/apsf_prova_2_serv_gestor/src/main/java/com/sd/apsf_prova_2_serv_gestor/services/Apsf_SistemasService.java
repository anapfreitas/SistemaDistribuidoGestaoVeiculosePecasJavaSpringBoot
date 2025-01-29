package com.sd.apsf_prova_2_serv_gestor.services;

import org.springframework.http.MediaType;

import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Apsf_SistemasService {

	private final RestTemplate apsf_RestTemplate;

	// URLs dos Servidores
	private final String apsf_UrlServ1Veiculos;
	private final String apsf_UrlServ2Pecas;
	private final String apsf_UrlServ2VeiculoPecas;

	public Apsf_SistemasService() {
		this.apsf_RestTemplate = new RestTemplate();

		// URLs do Servidor 1
		this.apsf_UrlServ1Veiculos = "http://localhost:8812/api/veiculos";

		// URLs do Servidor 2
		this.apsf_UrlServ2Pecas = "http://localhost:8813/api/pecas";
		this.apsf_UrlServ2VeiculoPecas = "http://localhost:8813/api/veiculo-pecas";
	}

	// Métodos para o Servidor 1 - API Veículos
	public ResponseEntity<String> apsf_GetVeiculos() {
		return apsf_RestTemplate.getForEntity(apsf_UrlServ1Veiculos, String.class);
	}

	public ResponseEntity<String> apsf_SalvarVeiculo(String veiculoJson) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<>(veiculoJson, headers);

		return apsf_RestTemplate.postForEntity(apsf_UrlServ1Veiculos, request, String.class);
	}

	public ResponseEntity<String> apsf_DeletarVeiculo(String veiculoJson) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<>(veiculoJson, headers);

		return apsf_RestTemplate.exchange(apsf_UrlServ1Veiculos, HttpMethod.DELETE, request, String.class);
	}

	// Métodos para o Servidor 2 - API Peças
	public ResponseEntity<String> apsf_GetPecas() {
		return apsf_RestTemplate.getForEntity(apsf_UrlServ2Pecas, String.class);
	}

	public ResponseEntity<String> apsf_SalvarPeca(String pecaJson) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<>(pecaJson, headers);

		return apsf_RestTemplate.postForEntity(apsf_UrlServ2Pecas, request, String.class);
	}

	public ResponseEntity<String> apsf_DeletarPeca(String pecaJson) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<>(pecaJson, headers);

		return apsf_RestTemplate.exchange(apsf_UrlServ2Pecas, HttpMethod.DELETE, request, String.class);
	}

	// Métodos para o Servidor 2 - API VeículoPecas
	public ResponseEntity<String> apsf_GetVeiculoPecas() {
		return apsf_RestTemplate.getForEntity(apsf_UrlServ2VeiculoPecas, String.class);
	}

	public ResponseEntity<String> apsf_SalvarVeiculoPeca(String veiculoPecaJson) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<>(veiculoPecaJson, headers);

		return apsf_RestTemplate.postForEntity(apsf_UrlServ2VeiculoPecas, request, String.class);
	}

	public ResponseEntity<String> apsf_DeletarVeiculoPeca(String veiculoPecaJson) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<>(veiculoPecaJson, headers);

		return apsf_RestTemplate.exchange(apsf_UrlServ2VeiculoPecas, HttpMethod.DELETE, request, String.class);
	}
}