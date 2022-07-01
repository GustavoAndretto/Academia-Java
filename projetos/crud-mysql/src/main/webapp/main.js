
function inserir() {
    var nome = document.getElementById('nome').value;
    var email = document.getElementById('email').value;

    fetch(`/crud/add?nome=${nome}&email=${email}`,
        {
            method: 'POST'
        })
        .then(res => res.text())
        .then(data => {
            document.getElementById('insertResult').innerHTML = data;
        });
}

function atualizarLista() {
    var tList = document.getElementById('tList');

    fetch('/crud/all')
        .then(res => res.json())
        .then(data => {
            let html = '';

            for (var i = 0; i < data.length; i++) {
                html += '<tr>';
                html += `<td>${data[i].id}</td>`;
                html += `<td>${data[i].nome}</td>`;
                html += `<td>${data[i].email}</td>`;
                html += '</tr>';
            }

            tList.innerHTML = html;
        })
}

function atualizarUsuario() {
    var id = document.getElementById('uId').value;
    var nome = document.getElementById('uNome').value;
    var email = document.getElementById('uEmail').value;

    fetch(`/crud/update?id=${id}&nome=${nome}&email=${email}`,
        {
            method: 'PUT'
        })
        .then(res => res.text())
        .then(data => {
            document.getElementById('updateResult').innerHTML = data;
        });
}

function deletarUsuario() {
    var id = document.getElementById('dId').value;

    fetch(`/crud/delete?id=${id}`,
        {
            method: 'DELETE'
        })
        .then(res => res.text())
        .then(data => {
            document.getElementById('deleteResult').innerHTML = data;
        });
}