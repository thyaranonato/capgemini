// função anônima
let z = function (n1, n2) {return n1 + n2};

// arrow function
let x = (n1, n2) => {return n1 + n2};

console.log(z(10, 20));
console.log(x(10, 20));

function consultar() {
    fetch("url")
        .then(x => x.text())
}