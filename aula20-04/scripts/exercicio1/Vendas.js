"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Venda {
    constructor(data, cliente) {
        this.data = data;
        this.cliente = cliente;
    }
    salvar() {
        console.log("Venda cadastrada com sucesso!!");
        return true;
    }
    alterar(id) {
        console.log("Venda alterada com sucesso!!");
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
        console.log("Venda excluída com sucesso!!");
    }
}
let v1 = new Venda("20/04/2022", "João");
v1.salvar();
v1.excluir(1);
