class Pessoa {
    id: number;
    nome: string;
    fone: string;
    email: string;

    constructor(id:number, nome:string, fone:string, email:string) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

    display():void {
        console.log(`
        Id: ${this.id},
        Nome: ${this.nome}
        Fone: ${this.fone}
        Email: ${this.email}
        `);
    }
}

let newPessoa = new Pessoa(10, "Maria", "123456", "maria@gmail.com" );
newPessoa.display();
