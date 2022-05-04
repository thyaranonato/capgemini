require('dotenv').config();
const express = require('express');
const app = express();
const pg = require('pg');

app.use(express.urlencoded({ extended: false }));
app.use(express.json());

let conString = process.env.SECRET_KEY;

const pool = new pg.Pool({ connectionString: conString, ssl: { rejectUnauthorized: false } });

app.get('/', (req, res) => {
    pool.connect((err, client) => {
        if(err) {
            return res.status(401).send('Conexão não autorizada!');
        }
        res.status(200).send('Conectado com sucesso!');
    });
});

app.get('/tabelaUsuario', (req, res) => {
    pool.connect((err, client) => {
        if(err) {
            return res.status(401).send('Conexão não autorizada!');
        }
        client.query('create table usuarios (email varchar(50), senha varchar(200), perfil varchar(15))', (error, result) => {
            if(error) {
               return res.status(401).send('Operação não autorizada!');
            }
            res.status(200).send(result.rows);
        });
    });
});

app.post('/usuarios', (req, res) => {
    pool.connect((err, client) => {
        if(err) {
            return res.status(401).send('Conexão não autorizada!');
        }
        client.query('select * from usuarios where email = $1', [req.body.email], (error, result) => {
            if(error) {
                return res.status(401).send('Operação não permitida');
            }
            if(result.rowCount > 0) {
                return res.status(200).send('Registro já existe!');
            }
            client.query('insert into usuarios (email, senha, perfil) values ($1,$2,$3)', [req.body.email, req.body.senha, req.body.perfil], (error, result) => {
                if(error) {
                    return res.status(403).send('Operação não permitida');
                }
                res.status(201).send({
                    mensagem: "Usuário cadastrado com sucesso!",
                    status: 201
                });
            });
        });
    });
});

app.get('/usuarios', (req, res) => {
    pool.connect((err, client) => {
        if(err) {
            return res.status(401).send('Conexão não autorizada!');
        }
        client.query('select * from usuarios', (error, result) => {
            if(error) {
                return res.status(403).send('Operação não permitida');
            }
            res.status(200).send(result.rows);
        });
    });
});

app.delete('/usuarios/:email', (req, res) => {
    pool.connect((err, client) => {
        if(err) {
            return res.status(401).send('Conexão não autorizada!');
        }
        client.query('delete from usuarios where email = $1', [req.params.email], (error, result) => {
            if(error) {
                return res.status(403).send('Operação não permitida');
            }
            res.status(200).send({
                mensagem: "Cadastro deletado com sucesso!",
                status: 200
            });
        });
    });
});

app.listen(8081, () => console.log('Aplicação em execução na porta 8081!'));
