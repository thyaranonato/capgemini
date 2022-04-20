import { IDaoGenerica } from "./IGenerica";
import { Produto } from "./Produto";

export default class Item implements IDaoGenerica<Item> {
    produto: Produto;
    preco: number;
    qtd:number;

    constructor(produto:Produto, preco:number, qtd:number) {
        this.produto = produto;
        this.preco  = preco;
        this.qtd = qtd;
    }
    salvar(): boolean {
        throw new Error("Method not implemented.");
    }
    excluir(id: number): number {
        throw new Error("Method not implemented.");
    }
    consultarTodos(): Item[] {
        throw new Error("Method not implemented.");
    }
    consultarPeloId(id: number): Item {
        throw new Error("Method not implemented.");
    }
    alterar(objeto: Item): boolean {
        throw new Error("Method not implemented.");
    }
}

