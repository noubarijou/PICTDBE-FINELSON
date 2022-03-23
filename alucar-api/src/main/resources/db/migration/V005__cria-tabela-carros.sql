create table carro (
	carro_id int not null AUTO_INCREMENT,
    modelo VARCHAR(30) not null,
    valor DOUBLE not null,
    unid_disponiveis int not null,
    categorias_id int not null,
    caracteristicas_id int not null,
    imagens_id int not null,

    PRIMARY KEY(carro_id)
);

alter table carro add constraint fk_carro_categorias
foreign key (categorias_id) references categorias (categorias_id);

alter table carro add constraint fk_carro_caracteristicas
foreign key (caracteristicas_id) references caracteristicas (caracteristicas_id);

alter table carro add constraint fk_carro_imagens
foreign key (imagens_id) references imagens (imagens_id);