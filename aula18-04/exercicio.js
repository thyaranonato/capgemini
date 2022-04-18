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
        this._cpf = cpf;
    }

    get cpf() {
        return this._cpf;
    }

    set cpf(value) {
        if(value.length === 14) {
            this._cpf = value;
        } else { console.log('CPF inválido!')}
    }
}

let pessoaFisica1 = new PessoaFisica("Maria", "4898989898989", "022011033-00");
console.log(pessoaFisica1);

let pf1 = new PessoaFisica("Ana", "ana@gmail.com");
pf1.cpf = "123.456.789-10";
console.log(pf1);

class PessoaJuridica extends Pessoa {
    constructor(nome, contato, cnpj) {
        super(nome, contato);
        this.cnpj = cnpj;
    }
}

let pessoaJuridica1 = new PessoaJuridica("Pedro", "4898989898989", "02201103388/0001-9");
console.log(pessoaJuridica1);
