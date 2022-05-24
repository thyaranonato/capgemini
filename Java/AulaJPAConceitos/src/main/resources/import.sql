insert into contato(nome, email) values ('maria','maria@gmail.com');
insert into contato(nome, email) values ('ana','ana@gmail.com');
insert into contato(nome, email) values ('josefa','josefa@gmail.com');
insert into contato(nome, email) values ('ursula','ursula@gmail.com');

insert into compromisso(data, hora, local,idcontato)values('2022-05-19','13:30:00','pizzaria',1);
insert into compromisso(data, hora, local,idcontato)values('2022-05-20','17:30:00','jogo',2);
insert into compromisso(data, hora, local,idcontato)values('2022-05-21','08:30:00','clube',3);
insert into compromisso(data, hora, local,idcontato)values('2022-05-21','13:30:00','aula',4);

insert into tb_cliente(nome, email) values('Maria', 'maria@gmail.com');
insert into tb_cliente(nome, email) values('Joana', 'joana@gmail.com');
insert into tb_cliente(nome, email) values('Pedro', 'pedro@gmail.com');

insert into tb_venda(dia_compra, cliente_id) values('2022-05-20', 1);
insert into tb_venda(dia_compra, cliente_id) values('2022-05-20', 2);
insert into tb_venda(dia_compra, cliente_id) values('2022-05-20', 3);
insert into tb_venda(dia_compra, cliente_id) values('2022-05-20', 1);