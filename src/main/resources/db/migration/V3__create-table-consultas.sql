create table consultas(

    id bigint not null auto_increment,
    veterinario_id bigint not null,
    animal_id bigint not null,
    produto_id bigint not null,
    data datetime not null,

    primary key(id),
    constraint fk_fk_consultas_veterinario_id foreign key(veterinario_id) references veterinarios(id),
    constraint fk_fk_consultas_animal_id foreign key(animal_id) references animal(id),
    constraint fk_fk_consultas_produto_id foreign key(produto_id) references produtos(id)

);