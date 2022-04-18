// Try - catch
function teste(n1, n2) {
    try {
        if(n2 === 0) {
            throw "Não é possível dividir por zero.";
        }

        if(n1 === undefined) {
            throw "Informe número";
        }

        let x = n1/n2

    } catch (error) {
        console.log(`Message: ${error}`);
    }
}

teste(undefined, 1);


function pegaDadosArray() {
    let array = [1, 2, 3, 4, 5, 6];
    try {
        let i = 6;
        if(i >= array.length) {
            throw "Indice de array inválido.";
        }
        let x = a[i];
    } catch(error) {
        console.log(error);
    }
}

pegaDadosArray();

// Finally
function conectar() {
    console.log("Abrindo conexão com o banco de dados!");
}

function desconectar() {
    console.log("Fechando conexão com o banco de dados!");
}

function cadastrar(dados) {
    try {
        conectar();

        if(dados === 2) {
            throw "Faltam dados a serem enviados para o DB."
        }

        console.log("Dados gravados com sucesso!!");
    } catch(error) {
        console.log(error);
    } finally {
        desconectar();
    }
}

cadastrar(10);
cadastrar(2);
