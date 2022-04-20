import { IDaoGenerica } from "./IGenerica";

class Produto implements IDaoGenerica<Produto>{
    descricao:string;
    valorUnitario:number;
    estoque:number;

    constructor(descricao:string, valorUnitario:number, estoque:number) {
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.estoque = estoque;
    }
    salvar(): boolean {
        throw new Error("Method not implemented.");
    }
    excluir(id: number): number {
        throw new Error("Method not implemented.");
    }
    consultarTodos(): Produto[] {
        throw new Error("Method not implemented.");
    }
    consultarPeloId(id: number): Produto {
        throw new Error("Method not implemented.");
    }
    alterar(objeto: Produto): boolean {
        throw new Error("Method not implemented.");
    }
}

export { Produto };