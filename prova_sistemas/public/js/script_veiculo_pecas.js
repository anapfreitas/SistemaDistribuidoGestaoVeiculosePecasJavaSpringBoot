jQuery.fn.exists = function() {
	return this.length > 0;
};

var serv_local = "localhost:8814";
var servico = "veiculo-pecas";
var lstVeiculoPecas;

// Função para carregar veículos no select da página
function carregarVeiculos() {
	const url = "http://" + serv_local + "/api/sistemas/veiculos";
	const select = $("#txtVeiculo");
	select.empty();
	select.append('<option value="" disabled selected>Selecione o veículo</option>');

	const xmlHTTP_GET = new XMLHttpRequest();
	xmlHTTP_GET.open("GET", url, false);
	xmlHTTP_GET.onreadystatechange = function() {
		if (xmlHTTP_GET.readyState === 4 && xmlHTTP_GET.status === 200) {
			const veiculos = JSON.parse(xmlHTTP_GET.responseText);
			veiculos.forEach((veiculo) => {
				select.append(`<option value="${veiculo.apsf_IdVeiculo}">${veiculo.apsf_Nome}</option>`);
			});
		}
	};
	xmlHTTP_GET.send();
}

// Função para carregar peças no select da página
function carregarPecas() {
	const url = "http://" + serv_local + "/api/sistemas/pecas";
	const select = $("#txtPeca");
	select.empty();
	select.append('<option value="" disabled selected>Selecione a peça</option>');

	const xmlHTTP_GET = new XMLHttpRequest();
	xmlHTTP_GET.open("GET", url, false);
	xmlHTTP_GET.onreadystatechange = function() {
		if (xmlHTTP_GET.readyState === 4 && xmlHTTP_GET.status === 200) {
			const pecas = JSON.parse(xmlHTTP_GET.responseText);
			pecas.forEach((peca) => {
				select.append(`<option value="${peca.apsf_IdPeca}">${peca.apsf_Nome}</option>`);
			});
		}
	};
	xmlHTTP_GET.send();
}


function salvar() {
	const url = "http://" + serv_local + "/api/sistemas/" + servico;
	const veiculoPeca = {
		apsf_IdVeiculo: parseInt($("#txtVeiculo").val()),
		apsf_IdPeca: parseInt($("#txtPeca").val()),
		apsf_Quantidade: $("#txtQuantidade").val()
	};

	const xmlHTTP_POST = new XMLHttpRequest();
	xmlHTTP_POST.open("POST", url, false);
	xmlHTTP_POST.setRequestHeader("Content-type", "application/json");
	xmlHTTP_POST.send(JSON.stringify(veiculoPeca));

	if (xmlHTTP_POST.status === 200 || xmlHTTP_POST.status === 201) {
		alert("Veículo-Peça salva com sucesso!");
		consultar();
		limparCampos();
	} else {
		alert("Erro ao salvar Veículo-Peça!");
	}
}


function consultar() {
	const url = "http://" + serv_local + "/api/sistemas/" + servico;

	const xmlHTTP_GET = new XMLHttpRequest();
	xmlHTTP_GET.open("GET", url, false);
	xmlHTTP_GET.onreadystatechange = function() {
		if (xmlHTTP_GET.readyState === 4 && xmlHTTP_GET.status === 200) {
			lstVeiculoPecas = JSON.parse(xmlHTTP_GET.responseText);
		}
	};
	xmlHTTP_GET.send();
	preencherTabela();
}


function preencherTabela() {
	const tbody = $("table tbody");
	tbody.empty();

	if (lstVeiculoPecas && lstVeiculoPecas.length > 0) {
		lstVeiculoPecas.forEach((item, index) => {
			tbody.append(`
                <tr>
                    <td>${item.apsf_IdVeiculo}</td>
                    <td>${item.apsf_IdPeca}</td>
                    <td>${item.apsf_Quantidade}</td>
                    <td><button class="btn btn-info" onclick="editar(${index})">Editar</button></td>
                    <td><button class="btn btn-danger" onclick="excluir(${index})">Excluir</button></td>
                </tr>
            `);
		});
	} else {
		tbody.append(`
            <tr>
                <td colspan="5">Nenhum veículo-peça encontrado.</td>
            </tr>
        `);
	}
}


function editar(index) {
	const veiculoPeca = lstVeiculoPecas[index];
	$("#txtVeiculo").val(veiculoPeca.apsf_IdVeiculo);
	$("#txtPeca").val(veiculoPeca.apsf_IdPeca);
	$("#txtQuantidade").val(veiculoPeca.apsf_Quantidade);
}


function excluir(index) {
	const veiculoPeca = lstVeiculoPecas[index];
	const url = "http://" + serv_local + "/api/sistemas/" + servico;

	const xmlHTTP_DELETE = new XMLHttpRequest();
	xmlHTTP_DELETE.open("DELETE", url, false);
	xmlHTTP_DELETE.setRequestHeader("Content-type", "application/json");
	xmlHTTP_DELETE.send(JSON.stringify(veiculoPeca));

	if (xmlHTTP_DELETE.status === 200) {
		alert("Veículo-Peça excluída com sucesso!");
		consultar();
	} else {
		alert("Erro ao excluir Veículo-Peça!");
	}
}


function limparCampos() {
	$("#txtVeiculo").val("");
	$("#txtPeca").val("");
	$("#txtQuantidade").val("");
}


$(document).ready(function() {
	carregarVeiculos();
	carregarPecas();
	consultar();
});
