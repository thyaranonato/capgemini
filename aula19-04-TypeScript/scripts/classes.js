"use strict";
class Pessoa {
    constructor(id, nome, fone, email) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }
    display() {
        console.log(`
        Id: ${this.id},
        Nome: ${this.nome}
        Fone: ${this.fone}
        Email: ${this.email}
        `);
    }
}
let newPessoa = new Pessoa(10, "Maria", "123456", "maria@gmail.com");
newPessoa.display();
