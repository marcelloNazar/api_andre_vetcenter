CREATE TABLE animal (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  especie VARCHAR(100),
  raca VARCHAR(100),
  proprietario_id BIGINT,
  FOREIGN KEY (proprietario_id) REFERENCES proprietarios(id)
);