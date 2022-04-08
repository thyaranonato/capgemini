// function ola() {
    // console.log("Hello World");
//    alert("Hello world");
// }

function montarNome(nome, sobrenome, idade) {
    let mensagem = "maior";
    if(idade < 18) {
        mensagem = "menor";
    }
    return `Olá ${nome} ${sobrenome}, você tem ${idade} anos, portanto você é ${mensagem} de idade.`
}

function validaIdade(idade) {
    if (idade < 18) {
        console.log("Você é menor de idade");
    } else {
        console.log("Você é maior de idade");
    }
}

function retornaSituacao(media) {
    let situacao = "Aprovado";
    if (media < 7) {
        situacao = "Reprovado"
    }
}

ola();
validaIdade(35);
let retorno = retornaSituacao(8);
console.log(retorno);