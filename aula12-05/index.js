const express = require('express');
const app = express();
const HOST = "0.0.0.0";
const PORT = "8080";

app.get('/', (req, res) => {
    res.status(200).send({ message: 'OK' });
});

app.listen(PORT, () => console.log(`Servidor em execução na url: http://${HOST}/${PORT}`));
