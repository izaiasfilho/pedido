CREATE TABLE IF NOT EXISTS TB_USUARIO_ATRIBUTO (
  id_produto UUID PRIMARY KEY,
  cod_ean VARCHAR(255) UNIQUE,
  cod_produto VARCHAR(255) NOT NULL UNIQUE,
  ds_produto VARCHAR(255) NOT NULL UNIQUE,
  vl_venda DECIMAL(10,2),
  vl_compra DECIMAL(10,2),
  vl_custo DECIMAL(10,2),
  qtd_estoque DECIMAL(10,2),
  dt_cadastro TIMESTAMP NOT NULL,
  dt_alteracao TIMESTAMP NOT NULL
);

-- Criação dos índices
CREATE INDEX idx_cod_ean ON TB_USUARIO_ATRIBUTO (cod_ean);
CREATE INDEX idx_ds_produto ON TB_USUARIO_ATRIBUTO (ds_produto);