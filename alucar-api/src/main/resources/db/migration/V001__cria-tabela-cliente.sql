create table cliente (
	cliente_id int not null AUTO_INCREMENT,
	cliente_nome varchar(30) not null,
	cliente_sobrenome varchar(30) not null,
  	email varchar(255) not null,
    telefone varchar(20) not null,
    data_nascimento varchar(10) not null,
    cpf varchar(15) not null,
    cnh varchar(20) not null,
    senha varchar(15) not null,
    funcao varchar(30) not null,

    primary key (cliente_id)
);