create table carro (
	carro_id int not null AUTO_INCREMENT,
    modelo VARCHAR(30) not null,
    valor DOUBLE not null,
    placa VARCHAR(7) not null,
    rating int not null,
    unid_disponiveis int not null,
    categorias_id int,
    imagens_id int,
    caracteristicas_id int,

    PRIMARY KEY(carro_id)
);

alter table carro add constraint fk_carro_categorias
foreign key (categorias_id) references categorias (categorias_id);

alter table carro add constraint fk_carro_imagens
foreign key (imagens_id) references imagens (imagens_id);

alter table carro add constraint fk_carro_caracteristicas
foreign key (caracteristicas_id) references caracteristicas (caracteristicas_id);

