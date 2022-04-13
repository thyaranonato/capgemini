let urlBase = "http://localhost:3000/contatos";

class Contato {
    constructor(id, nome, fone, email) {
        this.id = id,
        this.nome = nome,
        this.fone = fone,
        this.email = email
    }

    salvar() {
        fetch(urlBase, {
            method: 'POST',
            body: JSON.stringify(this),
            headers: {
                'Content-Type': 'application/json'
            }
        }).catch(erro => console.log(erro))
    }

    consultarTodos(display) {
        fetch(urlBase)
            .then(x => x.text())
            .then(data => display(data));
    }

    consultarPeloId(idContato, display) {
        fetch(`${urlBase}/${idContato}`)
            .then(x => x.text())
            .then(data => display(data));
    }

    editar() {
        fetch(`${urlBase}/${this.id}`, {
            method: 'PUT',
            body: JSON.stringify(this),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(x => x.text())
        .then(retornar())
    }

    deletar(id) {
        fetch(`${urlBase}/${id}`, {
            method: 'DELETE',
        })
    }
}