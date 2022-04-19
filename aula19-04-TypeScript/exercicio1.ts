class Itens {
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
}

let item1:Itens = new Itens("celular", 1000, 2);
item1.display(10);
