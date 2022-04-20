"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Item {
    constructor(produto, preco, qtd) {
        this.produto = produto;
        this.preco = preco;
        this.qtd = qtd;
    }
    salvar() {
        throw new Error("Method not implemented.");
    }
    excluir(id) {
        throw new Error("Method not implemented.");
    }
    consultarTodos() {
        throw new Error("Method not implemented.");
    }
    consultarPeloId(id) {
        throw new Error("Method not implemented.");
    }
    alterar(objeto) {
        throw new Error("Method not implemented.");
    }
}
exports.default = Item;
