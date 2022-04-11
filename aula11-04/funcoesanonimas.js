// função anônima
let x =  function (n1, n2) {
    return n1 + n2;
}

let z = x("ola", 20);
console.log(z);

// função autoinvoke
(
    function(n1, n2) {
        console.log(n1 + n2);
    }
) (20, 30);
