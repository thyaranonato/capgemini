const express = require('express');
const app = express();

app.get('/', (req, res) => {
    res.status(200).send('OK');
})

app.listen(8081, () => console.log('Aplicação em execução na porta 8081!'));
