let soma = function(n1, n2) {
    return n1 + n2;
}

let subtracao = (n1, n2) => { return n1 - n2 };

let multiplicacao = (n1, n2) => { 
    try {
        if(n1 ===  undefined || n2 === undefined) {
            throw "Informe um valor para n1 e n2.";
        }
        return n1 * n2;
   } catch(error) {
        return error;
   }
 };

let divisao = (n1, n2) => { 
   try {
        if(n1 === undefined || n2 === undefined) {
            throw "Informe um valor para n1 e n2.";
        }

        if(n2 === 0) {
            throw "Não é possível dividir por zero.";
        }

        return n1 / n2;
   } catch(error) {
        return error;
   }
};

let chamadaFuncao = function(res) {
    res.write('<h1>Testando função soma</h1>');
    res.write(`100 + 50 = ${soma(100, 50)}`);
    res.write('<hr>');

    res.write('<h1>Testando função subtração</h1>');
    res.write(`100 - 50 = ${subtracao(100, 50)}`);
    res.write('<hr>');

    res.write('<h1>Testando função multiplicação</h1>');
    res.write(`100 * 50 = ${multiplicacao(100, 50)}`);
    res.write('<hr>');

    res.write('<h1>Testando função divisão</h1>');
    res.write(`100 / 50 = ${divisao(100, 50)}`);
}

module.exports = { soma, subtracao, multiplicacao, divisao, chamadaFuncao };