create table imagens (
	imagens_id int not null AUTO_INCREMENT,
    titulo VARCHAR(60) not null,
    url_imagem VARCHAR(500) not null,

    PRIMARY KEY (imagens_id)
);