const express = require('express');
const app = express();

app.get('/', (_req, res) => {
    res.send('Hello World!');
});

app.get('/contatos', (_req, res) => {
    res.send('Serviço de contato');
});

app.post('/contatos', (_req, res) => {
    res.status(201).send({
       id: 1,
       nome: 'Joana',
       fone: '12345678',
       email: 'joana@gmail.com'
    });
});

app.listen(8081, () => {
    console.log('Aplicação em execução na PORTA 8081');
});
