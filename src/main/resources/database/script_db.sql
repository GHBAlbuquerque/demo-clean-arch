
insert into pessoa(id, celular, cpf, dt_nasc, email, nome, sobrenome) values (1, '976548763', '09875487659', {ts '2012-09-17 18:47:52.69'}, 'email1@email.com', 'Ana', 'Silva');
insert into pessoa(id, celular, cpf, dt_nasc, email, nome, sobrenome) values (2, '987664387', '09823456659', {ts '2014-10-17 18:47:52.69'}, 'email2@email.com', 'Joao', 'Silva');
insert into pessoa(id, celular, cpf, dt_nasc, email, nome, sobrenome) values (3, '945678763', '09871234558', {ts '2020-03-11 18:47:52.69'}, 'email3@email.com', 'Paula', 'Santos');

insert into proprietario(id, pessoa_id) values (1, 1);
insert into proprietario(id, pessoa_id) values (2, 3);

insert into inquilino(id, pessoa_id) values (1, 2);

insert into propriedade(id, ativa, endereco_bairro, endereco_cep, endereco_cidade, endereco_complemento, endereco_estado, endereco_logradouro, endereco_numero, metragem, valor_aluguel, proprietario_id)
values (1, true, 'bairro 1', '07975648', 'cidade', '100', 'SP', 'avenida', '1', '15', '1000', 1);

insert into propriedade(id, ativa, endereco_bairro, endereco_cep, endereco_cidade, endereco_complemento, endereco_estado, endereco_logradouro, endereco_numero, metragem, valor_aluguel, proprietario_id)
values (2, true, 'bairro 2', '04565648', 'cidade', '200', 'RJ', 'avenida', '2', '16', '1200', 2);

insert into visitas(id, ativa, endereco_bairro, endereco_cep, endereco_cidade, endereco_complemento, endereco_estado, endereco_logradouro, endereco_numero, metragem, valor_aluguel, proprietario_id)
values (2, true, 'bairro 2', '04565648', 'cidade', '200', 'RJ', 'avenida', '2', '16', '1200', 2);

insert into visita(id, ativa, data_agendamento, data_visita, inquilino_id, propriedade_id, proprietario_id)
values (1, true, {ts '2020-03-11 18:47:52.69'}, {ts '2020-04-11 18:47:52.69'}, 1, 1, 1);