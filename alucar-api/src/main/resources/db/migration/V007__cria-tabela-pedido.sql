create table pedido (
	pedido_id int not null AUTO_INCREMENT,
	data_retirada date not null,
	horario_retirada varchar(15) not null,
	data_entrega date not null,
	horario_entrega varchar(15) not null,
	local_retirada varchar(60) not null,
	local_entrega varchar(60) not null,
	cliente_id int not null,
    cidades_id int not null,
    carro_id int not null,

	primary key (pedido_id)
);

alter table pedido add constraint fk_pedido_cliente
foreign key (cliente_id) references cliente (cliente_id);

alter table pedido add constraint fk_pedido_cidades_id
foreign key (cidades_id) references cidades (cidades_id);

alter table pedido add constraint fk_pedido_carro
foreign key (carro_id) references carro (carro_id);