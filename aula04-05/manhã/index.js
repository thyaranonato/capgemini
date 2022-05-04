const express = require('express');
const app = express();
const PORT = 8081;
let rotasProduto = require('./rotasProduto');
let rotasCliente = require('./rotasCliente');

app.use('/produtos', rotasProduto);
app.use('/clientes', rotasCliente);

app.listen(PORT, () => console.log(`Aplicação em execução na porta ${PORT}`));
