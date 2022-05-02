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

app.listen(8081, () => {
    console.log('Aplicação em execução na PORTA 8081');
});
