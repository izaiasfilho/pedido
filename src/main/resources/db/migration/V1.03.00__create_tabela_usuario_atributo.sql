
CREATE TABLE IF NOT EXISTS USUARIO_ATRIBUTO (
  id UUID PRIMARY KEY,
  dt_cadastro TIMESTAMP NOT NULL,
  dt_alteracao TIMESTAMP NOT NULL,
  id_usuario_logado UUID NOT NULL,
  usuario_id UUID NOT NULL,
  FOREIGN KEY (usuario_id) REFERENCES TB_USUARIO (id),
  FOREIGN KEY (id_usuario_logado) REFERENCES TB_USUARIO (id)
);

CREATE INDEX idx_usuatrib_usuario_id ON USUARIO_ATRIBUTO (usuario_id);
CREATE INDEX idx_usuatrib_id_usuario_logado ON USUARIO_ATRIBUTO (id_usuario_logado);










