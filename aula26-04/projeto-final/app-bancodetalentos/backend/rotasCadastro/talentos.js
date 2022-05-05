const express = require('express');
const app = express();
const cors = require('cors');
const pg = require('pg');

app.use(express.urlencoded({ extended: false }));
app.use(express.json());
app.use(cors());

let conString = process.env.DATABASE_URL;

const pool = new pg.Pool({ connectionString: conString, ssl: { rejectUnauthorized: false } });

app.get('/criartabelatalentos', (req, res) => {
  pool.connect((err, client) => {
      if(err){
          return res.status(401).send('Conexão não autorizada')
      }
      var sql = 'CREATE TABLE talentos (id SERIAL PRIMARY KEY NOT NULL, nome VARCHAR(20) NOT NULL, sobrenome VARCHAR(70) NOT NULL, fone VARCHAR(15) NOT NULL, email VARCHAR(50) NOT NULL, password VARCHAR(200) NOT NULL, profissao VARCHAR(60) NOT NULL, cidade VARCHAR(100) NOT NULL, estado VARCHAR(30) NOT NULL, imagem VARCHAR(500) NOT NULL, perfil VARCHAR(10))'
      client.query(sql, (error, result) => {
          if(error){
              return res.status(401).send('Operação não autorizada')
          }
          res.status(200).send(result.rows)
      })
  })
})

app.get('/talentos', (req, res) => {
    pool.connect((err, client) => {
      if(err) {
        return res.status(401).send('Conexão não autorizada')
      }
      client.query('SELECT * FROM talentos', (error, result) => {
        if(error) {
          return res.status(401).send('Não autorizado')
        }
        res.status(200).send(result.rows)
      })
    })
});

app.get('/talentos/:id', (req, res) => {
    pool.connect((err, client) => {
        if (err) {
            return res.status(401).send("Conexão não autorizada")
        }
        client.query('SELECT * FROM talentos WHERE id = $1', [req.params.id], (error, result) => {
            if (error) {
                return res.status(401).send('Operação não autorizada')
            }
            res.status(200).send(result.rows[0])
        })
    })
});

app.post('/talentos', (req, res) => {
    pool.connect((err, client) => {
        if(err) {
            return res.status(401).send('Conexão não autorizada!');
        }
        client.query('SELECT * FROM talentos where id=$1', [req.body.id], (error, result) => {
            if(error) {
                return res.status(401).send('Não permitida');
            }
            if(result.rowCount > 0) {
                return res.status(208).send('Cadastro já existe!');
            }
            var sql = 'INSERT INTO talentos (nome, sobrenome, fone, email, password, profissao, cidade, estado, imagem, perfil) VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10)';
            var dados = [req.body.nome, req.body.sobrenome, req.body.fone, req.body.email, req.body.password, req.body.profissao, req.body.cidade, req.body.estado, req.body.imagem, 'talento'];
            client.query(sql, dados, (error, result) => {
                if(error) {
                    return res.status(401).send('Operação não permitida');
                }
                return res.status(201).send({ message: 'Talento cadastrado com sucesso!!' });
            });
        });
    });
});

app.put('/talentos/:id', (req, res) => {
  pool.connect((err, client) => {
    if(err) {
      return res.status(401).send("Conexão não autorizada")
    }
    var sql = 'SELECT * FROM talentos WHERE id=$1'
    client.query(sql, [req.params.id], (error, result) => {
      if(error) {
        return res.status(401).send('Não permitido')
      }
      if(result.rowCount > 0) {
        let sql = 'UPDATE talentos SET nome=$1, sobrenome=$2, fone=$3, email=$4, password=$5, profissao=$6, cidade=$7, estado=$8, imagem=$9 WHERE id=$10'
        let dados = [req.body.nome, req.body.sobrenome, req.body.fone, req.body.email, req.body.password, req.body.profissao, req.body.cidade, req.body.estado, req.body.imagem, req.params.id]
        client.query(sql, dados, (error2, result2) => {
          if(error2) {
            return res.status(401).send('Operação não permitida')
          }
          if(result2.rowCount > 0) {
            return res.status(200).send({ message: 'Talento alterado com sucesso!'})
          }
        })
      } else {
        res.status(404).send('Talento não encontrado')
      }
    })
  })
});

app.delete('/talentos/:id', (req, res) => {
    pool.connect((err, client) => {
        if (err) {
          res.status(401).send("Conexão não autorizada")
        }

        client.query('DELETE FROM talentos WHERE id=$1', [req.params.id], (error, result) => {
            if (error) {
              return res.status(401).send("Operação não autorizada")
            }
            res.status(200).send("Excluído com sucesso")
        })
    })
})

app.listen(process.env.PORT || 8080, () => console.log('Aplicação em execução na PORTA 8080'))
