var serv_local = "localhost:8814";
var servicoPecas = "pecas";
var servicoVeiculoPecas = "veiculo-pecas";
var servicoVeiculos = "veiculos";

// Função para consultar a peça pelo nome e exibir os dados
function consultarPeca() {
	const nomePeca = $("#txtNomePeca").val();
	if (!nomePeca) {
		alert("Por favor, digite o nome da peça.");
		return;
	}

	const urlPeca = "http://" + serv_local + "/api/sistemas/" + servicoPecas;
	const urlVeiculoPecas = "http://" + serv_local + "/api/sistemas/" + servicoVeiculoPecas;

	// Consulta a peça pelo nome
	const xmlHTTP_GET = new XMLHttpRequest();
	xmlHTTP_GET.open("GET", urlPeca, false);

	xmlHTTP_GET.onreadystatechange = function() {
		if (xmlHTTP_GET.readyState === 4 && xmlHTTP_GET.status === 200) {
			const pecas = JSON.parse(xmlHTTP_GET.responseText);
			const peca = pecas.find((p) => p.apsf_Nome.toLowerCase() === nomePeca.toLowerCase());

			if (!peca) {
				alert("Peça não encontrada!");
				limparDados();
				return;
			}

			exibirDadosPeca(peca);

			// Consulta os veículos relacionados à peça
			const xmlHTTP_GET_VP = new XMLHttpRequest();
			xmlHTTP_GET_VP.open("GET", urlVeiculoPecas, false);
			xmlHTTP_GET_VP.onreadystatechange = function() {
				if (xmlHTTP_GET_VP.readyState === 4 && xmlHTTP_GET_VP.status === 200) {
					const veiculoPecas = JSON.parse(xmlHTTP_GET_VP.responseText);
					const veiculosRelacionados = veiculoPecas.filter(
						(vp) => vp.apsf_IdPeca === peca.apsf_IdPeca
					);

					if (veiculosRelacionados.length > 0) {
						consultarVeiculos(veiculosRelacionados);
					} else {
						limparTabelaVeiculos();
					}
				}
			};
			xmlHTTP_GET_VP.send();
		}
	};
	xmlHTTP_GET.send();
}

// Função para exibir os dados da peça
function exibirDadosPeca(peca) {
	$("#detalhesPeca").html(`
        <strong>ID:</strong> ${peca.apsf_IdPeca}<br>
        <strong>Nome:</strong> ${peca.apsf_Nome}<br>
        <strong>Descrição:</strong> ${peca.apsf_Descricao}<br>
        <strong>Dimensões (Alt x Larg x Prof):</strong> ${peca.apsf_Altura} x ${peca.apsf_Largura} x ${peca.apsf_Profundidade}<br>
        <strong>Material:</strong> ${peca.apsf_MaterialFabricacao}<br>
        <strong>Local Veículo:</strong> ${peca.apsf_LocalVeiculo}
    `);
}

// Função para consultar os veículos relacionados a uma peça
function consultarVeiculos(veiculosRelacionados) {
	const urlVeiculos = "http://" + serv_local + "/api/sistemas/" + servicoVeiculos;

	const xmlHTTP_GET_VEIC = new XMLHttpRequest();
	xmlHTTP_GET_VEIC.open("GET", urlVeiculos, false);

	xmlHTTP_GET_VEIC.onreadystatechange = function() {
		if (xmlHTTP_GET_VEIC.readyState === 4 && xmlHTTP_GET_VEIC.status === 200) {
			const veiculos = JSON.parse(xmlHTTP_GET_VEIC.responseText);
			const veiculosExibir = veiculos.filter((v) =>
				veiculosRelacionados.some((vr) => vr.apsf_IdVeiculo === v.apsf_IdVeiculo)
			);
			preencherTabelaVeiculos(veiculosExibir);
		}
	};
	xmlHTTP_GET_VEIC.send();
}

// Função para preencher a tabela de veículos relacionados
function preencherTabelaVeiculos(veiculos) {
	const tbody = $("#veiculosRelacionados tbody");
	tbody.empty();

	if (veiculos.length > 0) {
		veiculos.forEach((veiculo) => {
			tbody.append(`
                <tr>
                    <td>${veiculo.apsf_IdVeiculo}</td>
                    <td>${veiculo.apsf_Nome}</td>
                    <td>${veiculo.apsf_Modelo}</td>
                    <td>${veiculo.apsf_Marca}</td>
                    <td>${veiculo.apsf_Ano}</td>
                </tr>
            `);
		});
	} else {
		tbody.append(`
            <tr>
                <td colspan="5">Nenhum veículo relacionado.</td>
            </tr>
        `);
	}
}

// Função para limpar os dados da peça
function limparDados() {
	$("#detalhesPeca").html("Nenhuma peça selecionada.");
	limparTabelaVeiculos();
}

// Função para limpar a tabela de veículos relacionados
function limparTabelaVeiculos() {
	const tbody = $("#veiculosRelacionados tbody");
	tbody.empty();
	tbody.append(`
        <tr>
            <td colspan="5">Nenhum veículo relacionado.</td>
        </tr>
    `);
}

$(document).ready(function() {
	limparDados();
});
