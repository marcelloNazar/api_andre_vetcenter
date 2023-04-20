CREATE TABLE animal (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    especie VARCHAR(100) not null,
    ativo tinyint not null,
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
