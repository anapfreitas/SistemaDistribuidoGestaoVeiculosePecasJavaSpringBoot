jQuery.fn.exists = function() {
	return this.length > 0;
};

var serv_local = "localhost:8814";
var servico = "veiculos";
var lstVeiculos;


function salvarVeiculo() {
	const url = "http://" + serv_local + "/api/sistemas/" + servico;
	const veiculo = {
		apsf_Nome: $("#txtNome").val(),
		apsf_Modelo: $("#txtModelo").val(),
		apsf_Marca: $("#txtMarca").val(),
		apsf_Ano: parseInt($("#txtAno").val())
	};

	const xmlHTTP_POST = new XMLHttpRequest();
	xmlHTTP_POST.open("POST", url, false);
	xmlHTTP_POST.setRequestHeader("Content-type", "application/json");
	xmlHTTP_POST.send(JSON.stringify(veiculo));

	if (xmlHTTP_POST.status === 200 || xmlHTTP_POST.status === 201) {
		alert("Veículo salvo com sucesso!");
		consultarVeiculos();
		limparCamposVeiculo();
	} else {
		alert("Erro ao salvar veículo!");
	}
}


function consultarVeiculos() {
	const url = "http://" + serv_local + "/api/sistemas/" + servico;
	const xmlHTTP_GET = new XMLHttpRequest();
	xmlHTTP_GET.open("GET", url, false);

	xmlHTTP_GET.onreadystatechange = function() {
		if (xmlHTTP_GET.readyState === 4 && xmlHTTP_GET.status === 200) {
			lstVeiculos = JSON.parse(xmlHTTP_GET.responseText);
		}
	};

	xmlHTTP_GET.send();
	preencherTabelaVeiculos();
}


function preencherTabelaVeiculos() {
	const tbody = $("table tbody");
	tbody.empty();

	if (lstVeiculos && lstVeiculos.length > 0) {
		lstVeiculos.forEach((veiculo, index) => {
			tbody.append(`
                <tr>
                    <td>${veiculo.apsf_IdVeiculo}</td> <!-- Exibe o ID do veículo -->
                    <td>${veiculo.apsf_Nome}</td>
                    <td>${veiculo.apsf_Modelo}</td>
                    <td>${veiculo.apsf_Marca}</td>
                    <td>${veiculo.apsf_Ano}</td>
                    <td><button class="btn btn-info" onclick="editarVeiculo(${index})">Editar</button></td>
                    <td><button class="btn btn-danger" onclick="excluirVeiculo(${index})">Excluir</button></td>
                </tr>
            `);
		});
	} else {
		tbody.append(`
            <tr>
                <td colspan="7">Nenhum veículo encontrado.</td>
            </tr>
        `);
	}
}


function editarVeiculo(index) {
	const veiculo = lstVeiculos[index];

	$("#txtNome").val(veiculo.apsf_Nome);
	$("#txtModelo").val(veiculo.apsf_Modelo);
	$("#txtMarca").val(veiculo.apsf_Marca);
	$("#txtAno").val(veiculo.apsf_Ano);
}


function excluirVeiculo(index) {
	const veiculo = lstVeiculos[index];
	const url = "http://" + serv_local + "/api/sistemas/" + servico;

	const xmlHTTP_DELETE = new XMLHttpRequest();
	xmlHTTP_DELETE.open("DELETE", url, false);
	xmlHTTP_DELETE.setRequestHeader("Content-type", "application/json");
	xmlHTTP_DELETE.send(JSON.stringify(veiculo));

	if (xmlHTTP_DELETE.status === 200) {
		alert("Veículo excluído com sucesso!");
		consultarVeiculos();
	} else {
		alert("Erro ao excluir veículo!");
	}
}


function limparCamposVeiculo() {
	$("#txtNome").val("");
	$("#txtModelo").val("");
	$("#txtMarca").val("");
	$("#txtAno").val("");
}


$(document).ready(function() {
	consultarVeiculos();
});

