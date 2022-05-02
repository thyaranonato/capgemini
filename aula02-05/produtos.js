const express = require('express');
const app = express();
const cors = require('cors');
let dados = require('./dbProdutos');

app.use(express.urlencoded({ extended: false }));
app.use(express.json());

app.use(cors());

app.get('/produtos', (req, res) => {
    res.status(200).send(dados);
});

app.get('/produtos/:idProduto', (req, res) => {
    let idProduto = req.params.idProduto;
    let produto = {};

    for(let i of dados) {
        if (i.id == idProduto) {
            produto = i;
        }
    }
    res.status(200).send(produto);
});

app.post('/produtos', (req, res) => {
    let obj = {
        id: dados.length + 1,
        descricao: req.body.descricao,
        preco: req.body.preco,
        estoque: req.body.estoque
    }
    dados.push(obj);
    res.status(201).send(obj);
 });

app.put('/produtos/:idProduto', (req, res) => {
    let idProduto = req.params.idProduto;
    let update = {};
    for(let i of dados) {
        if(i.id == idProduto) {
            i.descricao = req.body.descricao,
            i.preco = req.body.preco,
            i.estoque = req.body.estoque
            update = i;
        }
    }
    res.status(200).send(update);
});

app.delete('/produtos/:idProduto', (req, res) => {
    let idProduto = req.params.idProduto;
    let posicao = 0;

    for(let i of dados) {
        if(i.id == idProduto) 
            break;
        posicao++;
    }
    dados.splice(posicao, 1);
    res.status(204).send();
});

app.listen(8081, () => {
    console.log('Aplicação em execução na PORTA 8081');
});
