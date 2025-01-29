jQuery.fn.exists = function() {
	return this.length > 0;
};

var serv_local = "localhost:8814";
var servico = "pecas";
var lstPecas;

function salvar() {
	const url = "http://" + serv_local + "/api/sistemas/" + servico;
	const peca = {
		apsf_IdPeca: $("#txtId").exists() ? parseInt($("#txtId").val()) : null,
		apsf_Nome: $("#txtNome").val(),
		apsf_Descricao: $("#txtDescricao").val(),
		apsf_Altura: parseFloat($("#txtAltura").val()),
		apsf_Largura: parseFloat($("#txtLargura").val()),
		apsf_Profundidade: parseFloat($("#txtProfundidade").val()),
		apsf_MaterialFabricacao: $("#txtMaterial").val(),
		apsf_LocalVeiculo: $("#txtLocal").val()
	};

	const xmlHTTP_POST = new XMLHttpRequest();
	xmlHTTP_POST.open("POST", url, false);
	xmlHTTP_POST.setRequestHeader("Content-type", "application/json");
	xmlHTTP_POST.send(JSON.stringify(peca));

	if (xmlHTTP_POST.status === 200 || xmlHTTP_POST.status === 201) {
		alert("Peça salva/atualizada com sucesso!");
		consultar();
		limparCampos();
	} else {
		alert("Erro ao salvar/atualizar peça!");
	}
}


function consultar() {
	const url = "http://" + serv_local + "/api/sistemas/" + servico;
	const xmlHTTP_GET = new XMLHttpRequest();
	xmlHTTP_GET.open("GET", url, false);

	xmlHTTP_GET.onreadystatechange = function() {
		if (xmlHTTP_GET.readyState === 4 && xmlHTTP_GET.status === 200) {
			lstPecas = JSON.parse(xmlHTTP_GET.responseText);
		}
	};

	xmlHTTP_GET.send();
	preencherTabela();
}


function preencherTabela() {
	const tbody = $("table tbody");
	tbody.empty();

	if (lstPecas && lstPecas.length > 0) {
		lstPecas.forEach((peca, index) => {
			tbody.append(`
                <tr>
                    <td>${peca.apsf_IdPeca}</td> <!-- Adicionado o ID da peça -->
                    <td>${peca.apsf_Nome}</td>
                    <td>${peca.apsf_Descricao}</td>
                    <td>${peca.apsf_Altura.toFixed(2)}</td>
                    <td>${peca.apsf_Largura.toFixed(2)}</td>
                    <td>${peca.apsf_Profundidade.toFixed(2)}</td>
                    <td>${peca.apsf_MaterialFabricacao}</td>
                    <td>${peca.apsf_LocalVeiculo}</td>
                    <td><button class="btn btn-info" onclick="editar(${index})">Editar</button></td>
                    <td><button class="btn btn-danger" onclick="excluir(${index})">Excluir</button></td>
                </tr>
            `);
		});
	} else {
		tbody.append(`
            <tr>
                <td colspan="10">Nenhuma peça encontrada.</td>
            </tr>
        `);
	}
}


function editar(index) {
	const peca = lstPecas[index];

	if (!$("#txtId").exists()) {
		$("#campoId").append(`
            <input type="hidden" id="txtId" value="${peca.apsf_IdPeca}" />
        `);
	}

	$("#txtNome").val(peca.apsf_Nome);
	$("#txtDescricao").val(peca.apsf_Descricao);
	$("#txtAltura").val(peca.apsf_Altura);
	$("#txtLargura").val(peca.apsf_Largura);
	$("#txtProfundidade").val(peca.apsf_Profundidade);
	$("#txtMaterial").val(peca.apsf_MaterialFabricacao);
	$("#txtLocal").val(peca.apsf_LocalVeiculo);
}


function excluir(index) {
	const peca = lstPecas[index];
	const url = "http://" + serv_local + "/api/sistemas/" + servico;

	const xmlHTTP_DELETE = new XMLHttpRequest();
	xmlHTTP_DELETE.open("DELETE", url, false);
	xmlHTTP_DELETE.setRequestHeader("Content-type", "application/json");
	xmlHTTP_DELETE.send(JSON.stringify(peca));

	if (xmlHTTP_DELETE.status === 200) {
		alert("Peça excluída com sucesso!");
		consultar();
	} else {
		alert("Erro ao excluir peça!");
	}
}


function limparCampos() {
	$("#txtId").remove();
	$("#txtNome").val("");
	$("#txtDescricao").val("");
	$("#txtAltura").val("");
	$("#txtLargura").val("");
	$("#txtProfundidade").val("");
	$("#txtMaterial").val("");
	$("#txtLocal").val("");
}


$(document).ready(function() {
	consultar();
});
