//require('dotenv').config();
const express = require('express');
const app = express();
const pg = require('pg');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const login = require('./middlewares/login');
app.use(express.urlencoded({ extended: false }));
app.use(express.json());

// let conString = process.env.SECRET_KEY;
let conString = process.env.DATABASE_URL;
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
            bcrypt.hash(req.body.senha, 10, (error, hash) => {
                if(error) {
                    return res.status(500).send({ 
                        message: 'Erro de autenticação!',
                        error: error.message
                    });
                }
                client.query('insert into usuarios (email, senha, perfil) values ($1,$2,$3)', [req.body.email, hash, req.body.perfil], (error, result) => {
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

app.get('/usuarios/:email', (req, res) => {
    pool.connect((err, client) => {
        if(err) {
            return res.status(401).send('Conexão não autorizada!');
        }
        client.query('select * from usuarios where email = $1', [req.params.email], (error, result) => {
            if(error) {
                return res.status(403).send('Operação não permitida');
            }
            res.status(200).send(result.rows[0]);
        });
    });
});

app.post('/usuarios/login', (req, res) => {
    pool.connect((err, client) => {
        if (err) {
            return res.status(401).send("Conexão não autorizada!")
        };
        client.query('select * from usuarios where email = $1', [req.body.email], (error, result) => {
            if (error) {
                return res.status(401).send('Operação não permitida!')
            };
            if (result.rowCount > 0) {
                //cripotgrafar a senha enviada e comparar com a recuperada do banco
                bcrypt.compare(req.body.senha, result.rows[0].senha, (error, results) => {
                    if (error) {
                        return res.status(401).send({
                            message: "Falha na autenticação"
                        });
                    };
                    if (results) { //geração do token
                        let token = jwt.sign({
                                email: result.rows[0].email,
                                perfil: result.rows[0].perfil
                            },
                            process.env.JWTKEY, { expiresIn: '1h' });
                        return res.status(200).send({
                            message: 'Conectado com sucesso!',
                            token: token
                        });
                    };
                });
            } else {
                return res.status(200).send({
                    message: 'Usuário não encontrado!'
                });
            };
        });
    });
});

app.put('/usuarios/:email', (req, res) => {
    pool.connect((err, client) => {
        if(err) {
            return res.status(401).send('Conexão não autorizada!');
        }
        client.query('select * from usuarios where email = $1', [req.params.email], (error, result) => {
            if(error) {
                return res.status(403).send('Operação não permitida');
            }
            if(result.rowCount > 0) {
                client.query('update usuarios set senha=$1, perfil=$2 where email=$3', [req.body.senha, req.body.perfil, req.params.email], (error, result) => {
                    if(error) {
                        return res.status(403).send('Operação não permitida');
                    }
                    if(result.rowCount > 0) {
                        return res.status(200).send('Cadastro atualizado com sucesso!!');
                    };
                });
            } else {
                res.status(200).send('Usuário não encontrado!');
            }
        });
    });
});

app.post('/produtos', login, (req, res) => {
    res.status(200).send('OK');
});

app.listen(process.env.PORT || 8081, () => console.log(`Aplicação em execução na porta 8081!`));
