"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Itens {
    constructor(descricao, preco, quantidade) {
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    totalItem() {
        return this.preco * this.quantidade;
    }
    valorDesconto(taxa) {
        return this.totalItem() * (taxa / 100);
    }
    display(taxa) {
        console.log(`
             Descrição..: ${this.descricao}
             Preço......: ${this.preco}
             Qtde.......: ${this.quantidade}
             Subtotal...: ${this.totalItem()}
             R$ desconto: ${this.valorDesconto(taxa)}
             R$ pago....: ${this.totalItem() - this.valorDesconto(taxa)}
        `);
    }
    salvar() {
        console.log("Item cadastrado com sucesso!!");
        return true;
    }
    alterar(id) {
        console.log("Item alterado com sucesso!!");
        return true;
    }
    consultar() {
        let x = [];
        return x;
    }
    consultarPorId(id) {
        return "Telefone";
    }
    excluir(id) {
        console.log("Item excluído com sucesso!!");
    }
}
let item1 = new Itens("celular", 1000, 2);
item1.display(10);
item1.salvar();
item1.excluir(1);
