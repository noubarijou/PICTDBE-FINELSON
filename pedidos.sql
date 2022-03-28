insert into pedido (`pedido_id`,
					`data_retirada`,
					`horario_retirada`,
                    `data_entrega`,
                    `horario_entrega`,
                    `local_retirada`,
                    `local_entrega`,
                    `valor_locacao`,
                    `valor_seguro`,
                    `periodo`,
                    `cliente_id`,
                    `cidades_id`,
                    `carro_id`)
values	(1, "14/04/2022", "09:00", "17/04/2022", "20:00", "São Paulo", "São Paulo", "240,00", "60,00", "4", 2, 4, 1),
		(2, "18/04/2022", "09:00", "21/04/2022", "20:00", "São Paulo", "Rio Janeiro", "240,00", "60,00", "4", 3, 4, 1),
        (3, "20/04/2022", "9:00", "23/04/2022", "20:00", "Paraná", "São Paulo", "240,00", "60,00", "4", 4, 8, 2),
        (4, "27/05/2022", "09:00", "30/05/2022", "20:00", "Cuiabá", "Campo Grande", "240,00", "60,00", "4", 2, 11, 3);
        