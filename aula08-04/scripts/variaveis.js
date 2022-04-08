let nome = "Thyara";
console.log(nome);
let peso = 66;
console.log(peso);

const preco = 7.8;
console.log(preco);

let estoque = 100;

if(estoque < 200) {
    let desconto = estoque * 0.10;
    console.log(desconto);
}

const cars = ["Saab", "Volvo", "BMW"];
cars.push("Fusca"); // add no final do array
cars.unshift("Bicicleta"); // add no inicio do array
cars.pop(); // remove do final do array
cars.shift(); // remove do início do array
console.log(cars);

let contato = {
    nome: "João",
    idade: 35,
    fone: "48999999999"
}

console.log(contato);

let x = function soma(n1, n2) {return n1 + n2};
console.log(x(10, 20));

// princípio da imutabilidade
let fruta = "maça";
fruta = "melancia";

