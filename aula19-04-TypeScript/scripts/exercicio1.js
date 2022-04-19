"use strict";
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
}
let item1 = new Itens("celular", 1000, 2);
item1.display(10);
