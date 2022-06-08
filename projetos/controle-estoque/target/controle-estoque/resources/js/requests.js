var produto = {
    lista: null,
    selecionado: null

}

function limparAlerta() {
    document.getElementById('alerta').innerHTML = '';
}

function inserirAlerta(tipo, mensagem) {
    var icon = '';

    switch(tipo){
        case 'warning':
        case 'danger':
            icon = 'bi-exclamation-triangle-fill';
            break;
        case 'success':
            icon = 'bi-check-circle-fill'
    }

    document.getElementById('alerta').innerHTML = `
        <div class="mt-3 alert alert-${tipo} alert-dismissible fade show" role="alert">
        <span><i class="bi ${icon}"></i> ${mensagem}</span>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>`;
}

function receberListaProdutos() {
    fetch('./produto')
    .then(res => res.json())
    .then(data => {
        produto.lista = data;
        inserirListaProdutos(data)});
}

function inserirListaProdutos(data) {
    var html = '';

    for(var i = 0; i < Object.keys(data).length; i++) {
        html += '<tr>';
        html += `<th scope="row">${data[i]["codigo"]}</th>`;
        html += `<td>${data[i]["categoria"]}</td>`;
        html += `<td>${data[i]["nome"]}</td>`;
        html += `<td>${data[i]["quantidade"]}</td>`;
        html += `<td>${data[i]["valor"]}</td>`;
        html += '<td>'
        html += `<button type="button" class="btn btn-sm btn-primary me-1" onclick="listaBotaoAlterar(${i})"><i class="bi bi-pencil-square"></i></button>`
        html += `<button type="button" class="btn btn-sm btn-danger" onclick="listaBotaoDeletar(${i})"><i class="bi bi-trash"></i></button></td>`;
        html += '</tr>';
    }

    exibirCarregamentoDeLista(false);

    document.getElementById('tabProdutos').innerHTML = html;
}

function limparFormulario() {
    document.getElementById("frmCodigo").value = '';
    document.getElementById("frmCategoria").value = '';
    document.getElementById("frmNome").value = '';
    document.getElementById("frmQuantidade").value = '';
    document.getElementById("frmValor").value = '';

    limparAlerta();

    produto.selecionado = null;
}

function exibirCarregamentoDeLista(val) {
    document.getElementById('loading').style.display = val ? 'd-flex' : 'none';
}

function executarAlteracao() {
    if(!produto.selecionado) {
        inserirAlerta('danger', 'Nenhum produto selecionado, utilize o campo `Código` e clique em pesquisar.');
        return;
    }

    var val = validarCampos();

    if(val) {
        var pk = produto.selecionado['id'];

        var json = JSON.stringify({
            'id': pk,
            'codigo': val.codigo, 
            'nome': val.nome, 
            'categoria': val.categoria, 
            'valor': val.valor, 
            'quantidade': val.quantidade});

        fetch('/produto',
        {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: json
        })
        .then(response => response.json())
        .then(data => {
            if(data['success'][0]) {
                inserirAlerta('success', 'Produto alterado com sucesso!');
            } else {
                inserirAlerta('danger', data['error'][0]);
            }
        })   
    }
}

function alterarProduto() {
    if(produto.selecionado) {
        var obj = produto.selecionado;

        document.getElementById("frmCodigo").value = obj['codigo'];
        document.getElementById("frmCategoria").value = obj['categoria'];
        document.getElementById("frmNome").value = obj['nome'];
        document.getElementById("frmQuantidade").value = obj['quantidade'];
        document.getElementById("frmValor").value = obj['valor'];
    }
}

function deletarProduto() {
    if(produto.selecionado) {

    }
}

function validarCampos() {
    var cod =  document.getElementById('frmCodigo');
    var nom = document.getElementById('frmNome');
    var cat = document.getElementById('frmCategoria');
    var val = document.getElementById('frmValor');
    var qtd = document.getElementById('frmQuantidade');

    if(!cod.value) {
        inserirAlerta('warning', 'Campo `Código` não pode ser nulo.');
        return;
    } else if(!nom.value) {
        inserirAlerta('warning', 'Campo `Nome` não pode ser nulo.');
        return;
    } else if(!qtd.value) {
        inserirAlerta('warning', 'Campo `Quantidade` não pode ser nulo.');
        return;
    } else if(!val.value) {
        inserirAlerta('warning', 'Campo `Valor` não pode ser nulo.');
        return;
    }

    return {
        codigo: cod.value, 
        nome: nom.value, 
        categoria: cat.value, 
        valor: val.value, 
        quantidade: qtd.value};
}

function inserirProduto() {
    var val = validarCampos();

    if(val){
        var json = JSON.stringify({
            'codigo': val.codigo, 
            'nome': val.nome, 
            'categoria': val.categoria, 
            'valor': val.valor, 
            'quantidade': val.quantidade});
    
        fetch('/produto',
        {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: json
        })
        .then(response => response.json())
        .then(data => {
            if(data['success'][0]) {
                inserirAlerta('success', 'Produto inserido com sucesso!');
            } else {
                inserirAlerta('danger', data['error'][0]);
            }
        })
    }
}

function carregarPagina(template) {
    carregarTemplate(template, 'content');
}

function carregarTemplate(template, element) {
    var el = document.getElementById(element);

    if(el) {
        fetch(`./resources/template/${template}.html`)
        .then(response => response.text())
        .then(data => {
            el.innerHTML = data;

            switch(template) {
                case 'listarProdutos':
                    receberListaProdutos();
                    break;
                case 'alterarProduto':
                    alterarProduto();
            }
        });
    }
}

function botaoProcurar() {

}

function listaBotaoAlterar(id) {
    produto.selecionado = produto.lista[id];

    carregarPagina('alterarProduto');
}

function listaBotaoDeletar(id) {
    produto.selecionado = produto.lista[id];

    deletarProduto();
}

function inicializar() {
    carregarTemplate('header', 'header');
    carregarTemplate('home', 'content');
    carregarTemplate('footer', 'footer');
}

inicializar();