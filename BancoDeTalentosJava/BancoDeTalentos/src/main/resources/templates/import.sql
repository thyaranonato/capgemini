INSERT INTO talento (nome, sobrenome, fone, email, password, profissao, cidade, estado, perfil) VALUES ('Mariana', 'Souza', '2365-6589', 'mari@email.com', '1234', 'Designer', 'Campo Grande', 'Mato Grosso do Sul', 'Talento');
INSERT INTO talento (nome, sobrenome, fone, email, password, profissao, cidade, estado, perfil) VALUES ('Camila', 'Pereira', '2365-6589', 'cami@email.com', '1234', 'Professora', 'Curitiba', 'Paraná', 'Talento');
INSERT INTO talento (nome, sobrenome, fone, email, password, profissao, cidade, estado, perfil) VALUES ('João', 'da Silva', '2365-6589', 'joao@email.com', '1234', 'Desenvolvedor', 'Palhoça', 'Santa Catarina', 'Talento');
INSERT INTO talento (nome, sobrenome, fone, email, password, profissao, cidade, estado, perfil) VALUES ('Pedro', 'Campos', '2365-6589', 'pedro@email.com', '1234', 'Designer', 'Foz do Iguaçu', 'Paraná', 'Talento');

insert into area_profissional(area) values('Tecnologia');
insert into area_profissional(area) values('Engenharia');
insert into area_profissional(area) values('Saúde');

INSERT INTO AREA_PROFISSIONAL_TALENTO(AREA_PROFISSIONAL_ID,TALENTO_ID)VALUES('2','3');
INSERT INTO AREA_PROFISSIONAL_TALENTO(AREA_PROFISSIONAL_ID,TALENTO_ID)VALUES('1','2');
INSERT INTO AREA_PROFISSIONAL_TALENTO(AREA_PROFISSIONAL_ID,TALENTO_ID)VALUES('3','4');
INSERT INTO AREA_PROFISSIONAL_TALENTO(AREA_PROFISSIONAL_ID,TALENTO_ID)VALUES('4','1');
