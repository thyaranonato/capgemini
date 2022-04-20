class Pessoa {
    id: number;
    nome: string;
    contato: string;

    constructor(id:number, nome:string, contato:string) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
    }

    salvar():boolean {
        console.log(`Salvando a pessoa ${this.nome}`);
        return true;
    }

    display():string {
        return (`Id: ${this.id}, Nome: ${this.nome}, Contato: ${this.contato}`);
    }
}

export default Pessoa;
