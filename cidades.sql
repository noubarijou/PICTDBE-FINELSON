create table `cidades` (
	`cidades_id` int not null AUTO_INCREMENT,
    `cidades_nome` varchar(30) not null,
    `estado` varchar(2) not null,
    `regiao` varchar(20),

    PRIMARY KEY (`cidades_id`)
);

INSERT INTO `dbalucar`.`cidades`(`cidades_id`,`cidades_nome`,`estado`, `regiao`)
VALUES 
(1,"Rio Branco","AC", "Norte"),
(2,"Maceió","AL", "Nordeste"),
(3,"Macapá","AP", "Norte"),
(4,"Manaus","AM", "Norte"),
(5,"Salvador","BA", "Nordeste"),
(6,"Fortaleza","CE", "Nordeste"),
(7,"Brasília","DF", "Centro-Oeste"),
(8,"Vitória","ES", "Sudeste"),
(9,"Goiânia","GO", "Centro-Oeste"),
(10,"São Luís","MA", "Nordeste"),
(11,"Cuiabá","MT", "Centro-Oeste"),
(12,"Campo Grande","MS", "Centro-Oeste"),
(13,"Belo Horizonte","MG", "Sudeste"),
(14,"Belém","PA", "Norte"),
(15,"João Pessoa","PB", "Nordeste"),
(16,"Curitiba","PR", "Sul"),
(17,"Recife","PE", "Nordeste"),
(18,"Teresina","PI", "Nordeste"),
(19,"Rio de Janeiro","RJ", "Sudeste"),
(20,"Natal","RN", "Nordeste"),
(21,"Porto Alegre","RS", "Sul"),
(22,"Porto Velho","RO", "Norte"),
(23,"Boa Vista","RR", "Norte"),
(24,"Florianópolis","SC", "Sul"),
(25,"São Paulo","SP", "Sudeste"),
(26,"Aracaju","SE", "Nordeste"),
(27,"Palmas","TO", "Norte");