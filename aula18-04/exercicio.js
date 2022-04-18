class Pessoa {
    constructor(nome, contato) {
        this.nome = nome,
        this.contato = contato
    }
}

let pessoa1 = new Pessoa("João", '48999999999');
console.log(pessoa1);

class PessoaFisica extends Pessoa {
    constructor(nome, contato, cpf) {
        super(nome, contato);
        this.cpf = cpf;
    }
}

let pessoaFisica1 = new PessoaFisica("Maria", "4898989898989", "022011033-00");
console.log(pessoaFisica1);

class PessoaJuridica extends Pessoa {
    constructor(nome, contato, cnpj) {
        super(nome, contato);
        this.cnpj = cnpj;
    }
}

let pessoaJuridica1 = new PessoaJuridica("Pedro", "4898989898989", "02201103388/0001-9");
console.log(pessoaJuridica1);
