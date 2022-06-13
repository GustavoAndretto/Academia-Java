const requestOrigin = 'http://127.0.0.1:8080/produto';

function clearForm() {
    document.getElementById("inputCodigo").value = null;
    document.getElementById("inputNome").value = null;
    document.getElementById("inputCategoria").value = null;
    document.getElementById("inputQuantidade").value = null;
    document.getElementById("inputValor").value = null;
}

function insert() {
    fetch(requestOrigin, {
        method: 'POST',
        body: JSON.stringify(getInputValues())
    })
    .then(response => response.json())
    .then(data => {
        // Informar se houve um erro ou atualizar a lista caso ocorra tudo certo
        if(data['success'] == true) {
            updateList();
        }
        else {
            console.log(data['error']);
        }
    })
}

function update() {
    fetch(requestOrigin, {
        method: 'PUT',
        body: JSON.stringify(getInputValues())
    })
    .then(response => response.json())
    .then(data => {
        // Informar se houve um erro ou atualizar a lista caso ocorra tudo certo
        if(data['success'] == true) {
            updateList();
        }
        else {
            console.log(data['error']);
        }
    })
}

function remove() {
    fetch(requestOrigin, {
        method: 'DELETE',
        body: JSON.stringify(getInputValues())
    })
    .then(response => response.json())
    .then(data => {
        // Informar se houve um erro ou atualizar a lista caso ocorra tudo certo
        if(data['success'] == true) {
            updateList();
        }
        else {
            console.log(data['error']);
        }
    })
}

function updateList() {
    fetch(requestOrigin, {
        method: 'GET'
    })
    .then(res => res.json())
    .then(data => {
        let htmlCode = '';

        for(p of data) {
            htmlCode += '<tr>';
            htmlCode += '<td>' + p["codigo"] + '</td>';
            htmlCode += '<td>' + p["nome"] + '</td>';
            htmlCode += '<td>' + p["categoria"] + '</td>';
            htmlCode += '<td>' + p["quantidade"] + '</td>';
            htmlCode += '<td>' + p["valor"] + '</td>';
            htmlCode += '</tr>';
        }

        document.getElementById("tableBody").innerHTML = htmlCode;
    })
}

function confirm() {
    switch (checkFormType()) {
        case 'insert':
            insert();
            break;
        case 'update':
            update();
            break;
        case 'remove':
            remove();
    }
}

function checkFormType() {
    radioInputs = document.querySelectorAll('input[name="radioInput"');

    for (const r of radioInputs) {
        if (r.checked) {
            return r.value;
        }
    }

    return '';
}

function getInputValues() {
    return obj = {
        codigo: document.getElementById("inputCodigo").value,
        nome: document.getElementById("inputNome").value,
        categoria: document.getElementById("inputCategoria").value,
        quantidade: document.getElementById("inputQuantidade").value,
        valor: document.getElementById("inputValor").value,
    }
}

function init() {

}

init();