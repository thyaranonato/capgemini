import Item from "./Item";

export default class Carrinho {
    itens: Item[];
    data: string;
    cliente: string;
    finalizado: boolean;

    constructor(data:string, cliente:string) {
        this.itens = [];
        this.data = data;
        this.cliente = cliente;
        this.finalizado = false;
    }

    add(it:Item):void {
        try {
            if(this.finalizado) {
                throw "Carrinho já finalizado!";
            };
        } catch(error) {
            console.log(error);
        }

        this.itens.push(it);
        console.log("Item adicionado com sucesso!!");
    }

    remove(it:Item):void {
        let posicao = this.itens.indexOf(it);

        if(posicao > -1) {
            // delete this.itens[posicao];
            this.itens.splice(posicao, 1);
        }
        console.log("Item removido com sucesso!!");
    }

    getTotal():number {
        let total:number = 0;
        for(let it of this.itens) {
            total += (it.preco * it.qtd)
        };
        return total;
    }

    finalizar():void {
        this.finalizado = true;
    }
}
