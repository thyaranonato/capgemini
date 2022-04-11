function soma(n1, n2) {
    let resultado = n1 + n2;
    console.log(resultado);
}

soma(10, 20);

function somaComRetorno(n1, n2) {
    let resultado = n1 + n2;
    return resultado;
}

let retorno = somaComRetorno(30, 40);
console.log(retorno);

function somaArray(array) {
    let resultado = 0;
    for(let i = 0; i < array.length; i++) {
        resultado = resultado + array[i];
    }
    return resultado;
}

let pesos = [10, 20, 30, 40];
console.log(somaArray(pesos));