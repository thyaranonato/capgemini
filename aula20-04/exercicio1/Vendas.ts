import { IDao } from "../interfaces/interfaces";

class Venda implements IDao {
    data: string;
    cliente: string;

    constructor(data: string, cliente: string) {
        this.data = data;
        this.cliente = cliente;
    }

    salvar(): boolean {
        console.log("Venda cadastrada com sucesso!!");
        return true;
    }

    alterar(id: number): boolean {
        console.log("Venda alterada com sucesso!!");
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
        console.log("Venda excluída com sucesso!!");
    }
}

let v1:Venda = new Venda("20/04/2022", "João");
v1.salvar();
v1.excluir(1);
