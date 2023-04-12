create table proprietarios(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    telefone varchar(20) not null,
    rua varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    uf varchar(2) not null,
    cidade varchar(100) not null,
    numero varchar(20) not null,
    complemento varchar(100) not null,

    primary key(id)


);