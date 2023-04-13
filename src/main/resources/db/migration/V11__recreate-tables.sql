create table proprietarios(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(14) not null,
    nascimento varchar(12) not null,
    sexo varchar(9) not null,
    nomeMae varchar(100) not null,
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

CREATE TABLE animal (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  especie VARCHAR(100) not null,
  raca VARCHAR(100) not null,
  sexo varchar(9) not null,
  peso VARCHAR(100) not null,
  idade VARCHAR(100) not null,
  cor VARCHAR(100) not null,
  temperamento VARCHAR(10) not null,
  castrado VARCHAR(2) not null,
  proprietario_id BIGINT,
  FOREIGN KEY (proprietario_id) REFERENCES proprietarios(id)



);

CREATE TABLE produtos (

    id bigint not null auto_increment,
    nome varchar(100) not null,
    valor varchar(15) not null,
    estoque varchar(10) not null,

    primary key(id)

);