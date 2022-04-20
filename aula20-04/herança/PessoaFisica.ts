import Pessoa from "./Pessoa";

abstract class PessoaFisica extends Pessoa {
    cpf: string;

    constructor(id:number, nome:string, contato:string, cpf:string) {
        super(id, nome, contato);
        this.cpf = cpf;
    }
    
    display():string {
       let p:string = super.display();

       return (`${p}, Cpf: ${this.cpf}`);
    }

    // métodos abstratos não podem ter implementação 
    abstract salvar(): boolean;
    abstract alterar(id: number): boolean;   
    abstract excluir(id: number): void;
    abstract consultar(): string[];      
    abstract consultarPorId(id: number): string
}

/**let pf1 = new PessoaFisica(2, "João", "joao@gmail.com", "123.456.789-10");
console.log(pf1.display());**/
