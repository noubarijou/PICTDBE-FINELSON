create table caracteristicas (
	caracteristicas_id int not null AUTO_INCREMENT,
    qtde_porta VARCHAR(2) not null,
    qtde_assento VARCHAR(2) not null,
    ar_condicionado boolean not null,
    tipo_combustivel VARCHAR(10) not null,
    cambio VARCHAR(15) not null,
    motor VARCHAR(20) not null,
    cor VARCHAR(15) not null,

    PRIMARY KEY (caracteristicas_id)
);