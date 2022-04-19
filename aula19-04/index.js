let http = require('http');
// let modulo = require('./modulos/funcoes');
let fs = require('fs');
let url = require('url');

function cadastrar(res) {
    fs.readFile('cadastro.html', (err, data) => {
        res.writeHead(200, { 'Content-Type': 'text/html'});
        res.write(data);
        res.end();
    });
}

function consultar(res) {
    fs.readFile('consulta.html', (err, data) => {
        res.writeHead(200, { 'Content-Type': 'text/html'});
        res.write(data);
        res.end();
    });
}

http.createServer(function(req, res) {
    //modulo.chamadaFuncao(res);
    let adr = url.parse(req.url, true);
    if(adr.pathname === '/cadastro.html') {
        cadastrar(res);
    }

    if(adr.pathname === '/consulta.html') {
        consultar(res);
    }
 
}).listen(8080);

console.log("Servidor rodando!");
