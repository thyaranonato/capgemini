const express = require('express');
const req = require('express/lib/request');
const app = express();

app.use(express.urlencoded({ extended: false }));
app.use(express.json());

app.get('/', (_req, res) => {
    res.send('Hello World!');
});

app.get('/contatos', (_req, res) => {
    res.send('Serviço de contato');
});

app.get('/contatos/:idContato', (req, res) => {
    let idContato = req.params.idContato;
    res.status(200).send({idContato: idContato});
});

app.post('/contatos', (_req, res) => {
    res.status(201).send({
       id: 1,
       nome: 'Joana',
       fone: '12345678',
       email: 'joana@gmail.com'
    });
});

app.delete('/contatos/:idContato', (req, res) => {
    // let idContato = req.params.idContato;
    res.status(204).send();
});

app.post('/produtos', (req, res) => {
    res.status(201).send({
        id: req.body.id,
        descricao: req.body.descricao,
        preco: req.body.preco,
        estoque: req.body.estoque
    });
});

app.put('/produtos/:idProduto', (req, res) => {
    let idProduto = req.params.idProduto;
    res.status(200).send({
        id: idProduto,
        descricao: req.body.descricao,
        preco: req.body.preco,
        estoque: req.body.estoque
    });
});

app.listen(8081, () => {
    console.log('Aplicação em execução na PORTA 8081');
});
