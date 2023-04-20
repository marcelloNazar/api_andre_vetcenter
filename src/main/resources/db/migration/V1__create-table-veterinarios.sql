create table veterinarios(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    crv varchar(6) not null unique,
    ativo tinyint not null,
    telefone varchar(20) not null,
    especialidade varchar(100) not null,
    rua varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    uf varchar(2) not null,
    cidade varchar(100) not null,
    numero varchar(20) not null,
    complemento varchar(100) not null,

    primary key(id)

);

create table proprietarios(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(14) not null,
    ativo tinyint not null,
    nascimento varchar(12) not null,
    sexo varchar(9) not null,
    nome_mae varchar(100) not null,
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

CREATE TABLE produtos (

    id bigint not null auto_increment,
    ativo tinyint not null,
    nome varchar(100) not null,
    valor varchar(15) not null,
    estoque varchar(10) not null,

    primary key(id)

);

CREATE TABLE users (

    id bigint not null auto_increment,
    login varchar(100) not null,
    password varchar(100) not null,

    primary key(id)

);