insert into area_profissional(area, created_at)values('Tecnologia', NOW());
insert into area_profissional(area, created_at)values('Engenharia', NOW());
insert into area_profissional(area, created_at)values('Saúde', NOW());
insert into area_profissional(area, created_at)values('Educação', NOW());

INSERT INTO talento(nome, sobrenome, fone, email, password, profissao, cidade, estado, perfil, created_at)VALUES('Mariana', 'Souza', '2365-6589', 'mari@email.com', '1234', 'Engenheira Ambiental', 'Campo Grande', 'Mato Grosso do Sul', 'Talento', NOW());
INSERT INTO talento(nome, sobrenome, fone, email, password, profissao, cidade, estado, perfil, created_at)VALUES('Camila', 'Pereira', '2365-6589', 'cami@email.com', '1234', 'Professora', 'Curitiba', 'Paraná', 'Talento', NOW());
INSERT INTO talento(nome, sobrenome, fone, email, password, profissao, cidade, estado, perfil, created_at)VALUES('João', 'da Silva', '2365-6589', 'joao@email.com', '1234', 'Desenvolvedor', 'Palhoça', 'Santa Catarina', 'Talento', NOW());
INSERT INTO talento(nome, sobrenome, fone, email, password, profissao, cidade, estado, perfil, created_at)VALUES('Pedro', 'Campos', '2365-6589', 'pedro@email.com', '1234', 'Médico Pediatra', 'Foz do Iguaçu', 'Paraná', 'Talento', NOW());

INSERT INTO talento_area(talento_id, area_id)values(1,2);
INSERT INTO talento_area(talento_id, area_id)values(2,4);
INSERT INTO talento_area(talento_id, area_id)values(3,1);
INSERT INTO talento_area(talento_id, area_id)values(4,3);