DROP DATABASE IF EXISTS SGCMAQ3037185;
CREATE DATABASE IF NOT EXISTS SGCMAQ3037185;

USE SGCMAQ3037185;

CREATE TABLE tipo_usuario(
	id int NOT NULL,
    modulo_administrativo varchar(1) NOT NULL,
    modulo_agendamento varchar(1) NOT NULL,
    modulo_atendimento varchar(1) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE usuario(
	id int NOT NULL,
    nome varchar(50),
    senha varchar(100) NOT NULL,
    tipo_usuario_id int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tipo_usuario_id) REFERENCES tipo_usuario (id)
);
