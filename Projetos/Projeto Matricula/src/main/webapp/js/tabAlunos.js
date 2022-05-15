
function initialize() {
    fetch('./getListAlunos')
    .then(res => res.json())
    .then(data => inserirLista(data));
}

function inserirLista(json) {
    var htmlLista = '';

    json["alunos"].forEach(aluno => {
        htmlLista += '<tr>';
        htmlLista += '<td>' + aluno["matricula"] + '</td>';
        htmlLista += '<td>' + aluno["nome"] + '</td>';
        htmlLista += '<td>' + aluno["email"] + '</td>';
        htmlLista += '<td>' + aluno["telefone"] + '</td>';
        htmlLista += '</tr>';
    });
    
    document.getElementById("tabAlunos").innerHTML = htmlLista;
}

initialize();

