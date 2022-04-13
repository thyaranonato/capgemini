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
    // display() {
    //    console.log(`id: ${this.id} Nome: ${this.nome}`);
    //}

    //getIdade() {
    //    let anoAtual = new Date();
    //    return anoAtual.getFullYear() - this.anoNascimento;
    //}
}

//let obj = new Contato(1, 'José', 2000, '123-4567', ///'jose@gmail.com');
//console.log(obj.display());
//console.log(obj.getIdade());
