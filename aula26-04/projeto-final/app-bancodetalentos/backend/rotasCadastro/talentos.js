const express = require('express');
const app = express();
const cors = require('cors');

let dados = require('../dados/dbTalentos');

app.use(express.urlencoded({ extended: false }));
app.use(express.json());

app.use(cors());

app.get('/talentos', (req, res) => {
    res.status(200).send(dados);
});

app.get('/talentos/:id', (req, res) => {
    let id = req.params.id;
    let talento = {};

    for(let response of dados) {
        if(response.id == id) {
            talento = response;
        }
    }
    res.status(200).send(talento);
});

app.post('/talentos', (req, res) => {
    let talento = {
        id: dados.length + 1,
        nome: req.body.nome,
        sobrenome: req.body.sobrenome,
        fone: req.body.fone,
        email: req.body.email,
        password: req.body.password,
        profissao: req.body.profissao,
        cidade: req.body.cidade,
        estado: req.body.estado,
        imagem: req.body.imagem,
        perfil: 'talento'
    }
    dados.push(talento);
    res.status(201).send(talento);
});

app.put('/talentos/:id', (req, res) => {
    let id = req.params.id;
    let update = {};

    for(let response of dados) {
        if(response.id == id) {
            response.nome = req.body.nome,
            response.sobrenome = req.body.sobrenome,
            response.fone = req.body.fone,
            response.email = req.body.email,
            response.password = req.body.password,
            response.profissao = req.body.profissao,
            response.cidade = req.body.cidade,
            response.estado = req.body.estado,
            response.imagem = req.body.imagem,
            response.perfil = req.body.perfil,
            update = response;
        }
    }
    res.status(200).send(update);
});

app.delete('/talentos/:id', (req, res) => {
    let id = req.params.id;
    let posicao = 0;

    for(let talento of dados) {
        if(talento.id == id) {
            break;
        }
        posicao++
    };
    dados.splice(posicao, 1);
    res.status(204).send();
});

app.listen(8080, () => {
    console.log('Aplicação em execução na PORTA 8080');
});
