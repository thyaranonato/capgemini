//require('dotenv').config();
const express = require('express');
const app = express();
const cors = require('cors');

let dados = require('../dados/dbTalentos');

app.use(express.urlencoded({ extended: false }));
app.use(express.json());

app.use(cors());

app.get('/talentos')
