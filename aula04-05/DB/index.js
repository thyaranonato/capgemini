const express = require('express');
const app = express();
const pg = require('pg');

app.use(express.urlencoded({ extended: false }));
app.use(express.json());

let conString = 'postgres://rwgbjtxgojbgja:bb0f0a87d845a40861863138ce235cbb99fab08e6ee2713dfaa6820338d60207@ec2-3-224-125-117.compute-1.amazonaws.com:5432/ddepau574rgdlr';

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
        client.query('insert into usuarios (email, senha, perfil) values ($1,$2,$3)', [req.body.email, req.body.senha, req.body.perfil], (error, result) => {
            if(error) {
                return res.status(403).send('Operação não permitida');
            }
            res.status(201).send(result.rows[0]);
        });
    });
});

app.listen(8081, () => console.log('Aplicação em execução na porta 8081!'));
