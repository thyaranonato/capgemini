"use strict";
var nome;
nome = "Ana";
console.log(nome);
function soma(n1, n2) {
    try {
        if (n1 === 0 || n2 === 0) {
            throw "Informe um valor para n1 e n2.";
        }
        return n1 + n2;
    }
    catch (error) {
        return error;
    }
}
function subtracao(n1, n2) {
    try {
        if (n1 === 0 || n2 === 0) {
            throw "Informe um valor para n1 e n2.";
        }
        return n1 - n2;
    }
    catch (error) {
        return error;
    }
}
function multiplicacao(n1, n2) {
    try {
        if (n1 === 0 || n2 === 0) {
            throw "Informe um valor para n1 e n2.";
        }
        return n1 * n2;
    }
    catch (error) {
        return error;
    }
}
function divisao(n1, n2) {
    try {
        if (n1 === 0 || n2 === 0) {
            throw "Informe um valor para n1 e n2.";
        }
        if (n2 === 0) {
            throw "Não é possível dividir por zero.";
        }
        return n1 / n2;
    }
    catch (error) {
        return error;
    }
}
