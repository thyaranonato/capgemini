"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const Pessoa_1 = __importDefault(require("./Pessoa"));
class PessoaFisica extends Pessoa_1.default {
    constructor(id, nome, contato, cpf) {
        super(id, nome, contato);
        this.cpf = cpf;
    }
    display() {
        let p = super.display();
        return (`${p}, Cpf: ${this.cpf}`);
    }
}
let pf1 = new PessoaFisica(2, "João", "joao@gmail.com", "123.456.789-10");
console.log(pf1.display());
