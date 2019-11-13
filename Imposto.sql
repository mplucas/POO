CREATE TABLE contribuinte (
	id SERIAL PRIMARY KEY,
	cpf VARCHAR(20),
	nome VARCHAR(100),
    idade INT,
    endereco VARCHAR(200),
    contabancaria INT
);

CREATE TABLE pessoajuridica (
	id SERIAL PRIMARY KEY,
	cnpj VARCHAR(25),
	nomePJ VARCHAR(100),
    endereco VARCHAR(200),
    numfuncionarios INT
);

CREATE TABLE dependente (
	id SERIAL PRIMARY KEY,
	cpf VARCHAR(20),
	nome VARCHAR(100),
    idade INT,
    endereco VARCHAR(200),
    id_contribuinte INT REFERENCES contribuinte (id)
);

CREATE TABLE bem (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100),
    tipo VARCHAR(50),
    valor FLOAT,
    id_contribuinte INT REFERENCES contribuinte (id)
);

CREATE TABLE notafiscal (
	id SERIAL PRIMARY KEY,
    numprotocolo INT,
	cnpj VARCHAR(25),
    valor FLOAT,
    id_contribuinte INT REFERENCES contribuinte (id),
    id_pessoajuridica INT REFERENCES pessoajuridica (id)
);

CREATE TABLE contracheque (
	id SERIAL PRIMARY KEY,
    numprotocolo INT,
	cnpj VARCHAR(25),
    valor FLOAT,
    id_contribuinte INT REFERENCES contribuinte (id),
    id_pessoajuridica INT REFERENCES pessoajuridica (id)
);