class Contato {
    nome: string;
    fone: string;

    constructor(nome:string, fone: string) {
        this.nome = nome;
        this.fone = fone;
    }
}

function testGenerics<T>(x:T): T {
    return x;
}

console.log(testGenerics<string>("Hello world!"));

console.log(testGenerics<number>(100));

let ct = new Contato("Ana", "35651322");
console.log(testGenerics<Contato>(ct));


function lista<T>(n1: T, n2: T): T[] {
    let x: T[] = [n1, n2];
    return x;
}

console.log(lista<string>("maria", "maria@gmail.com"));

function listaComIdade<T, U, Z>(p1: T, p2: U, p3: Z): void {
    console.log(`${p1}, ${p2}, ${p3}`);
}

listaComIdade<string, number, boolean>("maria", 20, true);

listaComIdade<number, boolean, string>(10, false, "hello");

listaComIdade<string, number, number[]>("joao", 75, [10, 7, 9]);
