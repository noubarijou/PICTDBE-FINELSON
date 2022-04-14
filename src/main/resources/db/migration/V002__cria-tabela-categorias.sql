create table categorias (
	categorias_id int not null AUTO_INCREMENT,
    categorias_nome VARCHAR(15) not null,
    url_img_modelo VARCHAR(500) not null,
    descricao VARCHAR(500) not null,
    preco double not null,

    PRIMARY KEY (categorias_id)
);