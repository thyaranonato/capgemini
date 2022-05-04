const express = require('express');
const router = express.Router();

router.get('/', (_req, res) => {
    res.status(200).send('Página principal produtos');
});

router.get('/:idProduto', (req, res) => {
    let id = req.params.idProduto;
    res.status(200).send({idSelecionado: id});
});

router.post('/', (_req, res) => {
    res.status(201).send({message: 'Produto criado com sucesso!!'});
});

module.exports = router;
