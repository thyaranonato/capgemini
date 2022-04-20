import Pessoa from "./Pessoa";

abstract class PessoaJuridica extends Pessoa {
    cnpj: string;

    constructor(id:number, nome:string, contato:string, cnpj:string) {
        super(id, nome, contato);
        this.cnpj = cnpj;
    }
    
    display():string {
       let p:string = super.display();

       return (`${p}, Cnpj: ${this.cnpj}`);
    }

    /**salvar(): boolean {
        console.log("Salvando pessoa jurídica");
        return true;
    }**/
    // métodos abstratos não podem ter implementação 
    abstract salvar(): boolean;
    abstract alterar(id: number): boolean;   
    abstract excluir(id: number): void;
    abstract consultar(): string[];      
    abstract consultarPorId(id: number): string
}

//**let pj1 = new PessoaJuridica(3, "Mercado Livre", "mercadolivre@gmail.com", "123456/0001-10");**/
// console.log(pj1.display());
