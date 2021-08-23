CREATE DATABASE rh;
USE rh;

CREATE TABLE funcionarios(
id int(5) AUTO_INCREMENT,
nome varchar(50),
ano_nascimento int(4),
cpf int (11),
salario decimal(10,2),
PRIMARY KEY (id)
);

INSERT INTO funcionarios(nome,ano_nascimento,cpf,salario)VALUES("Julianna", 1991, 1234567891,4500.00);
INSERT INTO funcionarios(nome,ano_nascimento,cpf,salario)VALUES("Leticia", 1993, 1234557810,5000.00);
INSERT INTO funcionarios(nome,ano_nascimento,cpf,salario)VALUES("Manuela", 1947, 1234557810,3500.00);
UPDATE funcionarios SET nome= "Marcos", salario = 2000.00 WHERE nome= "Manuela";

DESCRIBE funcionarios;

SELECT * FROM funcionarios WHERE salario > 2000;
SELECT * FROM funcionarios WHERE salario <= 2000;

SET SQL_SAFE_UPDATES = 0;