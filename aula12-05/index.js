const express = require('express');
const app = express();
const pg = require('pg');

const HOST = "0.0.0.0";
const PORT = "8080";

listaClientes = [
    {
        nome: 'José',
        fone: '4899999-9999',
        email: 'jose@gmail.com'
    },
    {
        nome: 'Ana',
        fone: '4899999-9999',
        email: 'ana@gmail.com'
    },
    {
        nome: 'Maria',
        fone: '4899999-9999',
        email: 'maria@gmail.com'
    }
];

const pool = new pg.Pool({
    user: 'postgres',
    password: 'admin',
    database: 'postgres',
    host: 'meubanco'
});

app.get('/conectar', (req, res) => {
    pool.connect((err, client) => {
        if(err) {
            return res.status(401).send({
                message: 'Conexão não permitida!',
                error: err.message
            });
        }
        res.status(200).send({ message: 'Conectado!' });
    });
});

app.get('/', (req, res) => {
    res.status(200).send({ message: 'OK' });
});

app.get('/clientes', (req, res) => {
    res.status(200).send(listaClientes);
});

app.listen(PORT, () => console.log(`Servidor em execução na url: http://${HOST}/${PORT}`));
