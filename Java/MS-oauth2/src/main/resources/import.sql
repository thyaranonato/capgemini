insert into tb_user(nome, email, senha) values('Maria', 'maria@gmail.com', '123456');
insert into tb_user(nome, email, senha) values('João', 'joao@gmail.com', '123456');

insert into tb_role(authority)values('ROLE_ADMIN');
insert into tb_role(authority)values('ROLE_USUARIO');

insert into tb_user_role(user_id, role_id)values(1,1);
insert into tb_user_role(user_id, role_id)values(2,2);