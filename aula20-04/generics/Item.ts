import { IDaoGenerica } from "./IGenerica";

class Item implements IDaoGenerica<Item> {
    descricao:string;
    preco: number;
    qtd:number;

    constructor(descricao:string, preco:number, qtd:number) {
        this.descricao = descricao;
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

