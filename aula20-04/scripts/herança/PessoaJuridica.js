"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const Pessoa_1 = __importDefault(require("./Pessoa"));
class PessoaJuridica extends Pessoa_1.default {
    constructor(id, nome, contato, cnpj) {
        super(id, nome, contato);
        this.cnpj = cnpj;
    }
    display() {
        let p = super.display();
        return (`${p}, Cnpj: ${this.cnpj}`);
    }
}
//**let pj1 = new PessoaJuridica(3, "Mercado Livre", "mercadolivre@gmail.com", "123456/0001-10");**/
// console.log(pj1.display());
