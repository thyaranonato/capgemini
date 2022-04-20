import Pessoa from "./Pessoa";

class PessoaJuridica extends Pessoa {
    cnpj: string;

    constructor(id:number, nome:string, contato:string, cnpj:string) {
        super(id, nome, contato);
        this.cnpj = cnpj;
    }
    
    display():string {
       let p:string = super.display();

       return (`${p}, Cnpj: ${this.cnpj}`);
    }
}

let pj1 = new PessoaJuridica(3, "Mercado Livre", "mercadolivre@gmail.com", "123456/0001-10");
console.log(pj1.display());
