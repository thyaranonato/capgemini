let http = require('http');
let add = require('./funcoes');

http.createServer(function(_req, res) {
   let z = add.soma(10, 20);
   res.writeHead(200, {'Content-Type': 'text/html'});
   res.write(`${z}`);
   res.end();

   console.log("Servidor rodando!!");
}).listen(8080);