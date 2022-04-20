import { IDao } from "../interfaces/interfaces";

class Itens implements IDao {
    descricao: string;
    preco: number;
    quantidade: number;

    constructor(descricao:string, preco:number, quantidade:number) {
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    totalItem():number {
        return this.preco * this.quantidade;
    }

    valorDesconto(taxa:number):number {
        return this.totalItem() * (taxa / 100);
    }

    display(taxa:number):void{
        console.log(`
             Descrição..: ${this.descricao}
             Preço......: ${this.preco}
             Qtde.......: ${this.quantidade}
             Subtotal...: ${this.totalItem()}
             R$ desconto: ${this.valorDesconto(taxa)}
             R$ pago....: ${this.totalItem() - this.valorDesconto(taxa)}
        `)
    }

    salvar(): boolean {
        console.log("Item cadastrado com sucesso!!");
        return true;
    }

    alterar(id: number): boolean {
        console.log("Item alterado com sucesso!!");
        return true;
    }

    consultar(): string[] {
        let x:string[] = [];
        return x;
    }

    consultarPorId(id: number): string {
        return "Telefone";
    }

    excluir(id: number): void {
        console.log("Item excluído com sucesso!!");
    }
}

let item1:Itens = new Itens("celular", 1000, 2);
item1.display(10)
item1.salvar();
item1.excluir(1);
