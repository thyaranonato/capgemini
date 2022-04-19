type Contato = {
    id: number;
    nome: string;
    fone: string;
    email: string;
}

var ct: Contato = {id:0, nome: "", fone: "", email:""};
ct.id = 10;
ct.nome = "Maria";
ct.fone = "123456";
ct.email = "maria@gmail.com"

console.log(ct);