create table pedido (
	pedido_id int not null AUTO_INCREMENT,
	data_retirada varchar(10) not null,
	horario_retirada varchar(15) not null,
	data_entrega varchar(10) not null,
	horario_entrega varchar(15) not null,
	local_retirada varchar(60) not null,
	local_entrega varchar(60) not null,
    valor_locacao double not null,
    valor_seguro double not null,
    periodo int not null,
	cliente_id int,
    cidades_id int,
    carro_id int,

	primary key (pedido_id)
);

alter table pedido add constraint fk_pedido_cliente
foreign key (cliente_id) references cliente (cliente_id);

alter table pedido add constraint fk_pedido_cidades_id
foreign key (cidades_id) references cidades (cidades_id);

alter table pedido add constraint fk_pedido_carro
foreign key (carro_id) references carro (carro_id);


