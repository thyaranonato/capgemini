"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Carrinho {
    constructor(data, cliente) {
        this.itens = [];
        this.data = data;
        this.cliente = cliente;
        this.finalizado = false;
    }
    add(it) {
        try {
            if (this.finalizado) {
                throw "Carrinho já finalizado!";
            }
            ;
        }
        catch (error) {
            console.log(error);
        }
        this.itens.push(it);
        console.log("Item adicionado com sucesso!!");
    }
    remove(it) {
        let posicao = this.itens.indexOf(it);
        if (posicao > -1) {
            // delete this.itens[posicao];
            this.itens.splice(posicao, 1);
        }
        console.log("Item removido com sucesso!!");
    }
    getTotal() {
        let total = 0;
        for (let it of this.itens) {
            total += (it.preco * it.qtd);
        }
        ;
        return total;
    }
    finalizar() {
        this.finalizado = true;
    }
}
exports.default = Carrinho;
