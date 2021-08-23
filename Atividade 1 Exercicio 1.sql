CREATE DATABASE rh;
USE rh;

CREATE TABLE funcionarios(
id int(5) AUTO_INCREMENT,
nome varchar(50),
ano_nascimento int(4),
cpf int (11),
PRIMARY KEY (id)
);

INSERT INTO funcionarios(nome,ano_nascimento,cpf)VALUES("Julianna", 1991, 1234567891);
INSERT INTO funcionarios(nome,ano_nascimento,cpf)VALUES("Leticia", 1993, 1234557810);
INSERT INTO funcionarios(nome,ano_nascimento,cpf)VALUES("Manuela", 1947, 1234557810);

DESCRIBE funcionarios;