"use strict";
class Contato {
    constructor(nome, fone) {
        this.nome = nome;
        this.fone = fone;
    }
}
function testGenerics(x) {
    return x;
}
console.log(testGenerics("Hello world!"));
console.log(testGenerics(100));
let ct = new Contato("Ana", "35651322");
console.log(testGenerics(ct));
function lista(n1, n2) {
    let x = [n1, n2];
    return x;
}
console.log(lista("maria", "maria@gmail.com"));
function listaComIdade(p1, p2, p3) {
    console.log(`${p1}, ${p2}, ${p3}`);
}
listaComIdade("maria", 20, true);
listaComIdade(10, false, "hello");
listaComIdade("joao", 75, [10, 7, 9]);
