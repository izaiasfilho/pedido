CREATE TABLE IF NOT EXISTS TB_USUARIO (
  id UUID PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  email VARCHAR(255) NOT NULL,
  dt_nascimento TIMESTAMP,
  status BOOLEAN
);

CREATE UNIQUE INDEX uk_tb_usuario_cpf ON TB_USUARIO (cpf);
CREATE UNIQUE INDEX uk_tb_usuario_email ON TB_USUARIO (email);
CREATE INDEX idx_nome ON TB_USUARIO (nome);
CREATE INDEX idx_cpf ON TB_USUARIO (cpf);
CREATE INDEX idx_email ON TB_USUARIO (email);