-- Tabela TB_ESTADO
CREATE TABLE TB_ESTADO (
    id UUID PRIMARY KEY,
    ds_sigla VARCHAR(255),
    ds_estado VARCHAR(255)
);

-- Tabela TB_CIDADE
CREATE TABLE TB_CIDADE (
    id UUID PRIMARY KEY,
    ds_cidade VARCHAR(255),
    ds_bairro VARCHAR(255),
    id_estado UUID,
    FOREIGN KEY (id_estado) REFERENCES TB_ESTADO(id)
);

-- Tabela TB_USUARIO
CREATE TABLE TB_USUARIO (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(20) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    dt_nascimento DATE,
    status BOOLEAN
);

-- Tabela TB_USUARIO_ATRIBUTO
CREATE TABLE TB_USUARIO_ATRIBUTO (
    id UUID PRIMARY KEY,
    id_usuario UUID,
    dt_cadastro DATE,
    dt_alteracao DATE,
    FOREIGN KEY (id_usuario) REFERENCES TB_USUARIO(id)
);

-- Tabela TB_ENDERECO
CREATE TABLE TB_ENDERECO (
    id UUID PRIMARY KEY,
    ds_logradouro VARCHAR(255),
    cep VARCHAR(255),
    numero BIGINT,
    ds_complemento VARCHAR(255),
    id_usuario_atributo UUID,
    id_cidade UUID,
    FOREIGN KEY (id_usuario_atributo) REFERENCES TB_USUARIO_ATRIBUTO(id),
    FOREIGN KEY (id_cidade) REFERENCES TB_CIDADE(id)
);


-- Criação de índice na tabela TB_ESTADO
CREATE INDEX idx_estado_sigla ON TB_ESTADO(ds_sigla);
CREATE INDEX idx_estado_descricao ON TB_ESTADO(ds_estado);

-- Criação de índice na tabela TB_CIDADE
CREATE INDEX idx_cidade_descricao ON TB_CIDADE(ds_cidade);
CREATE INDEX idx_cidade_estado ON TB_CIDADE(id_estado);

-- Criação de índice na tabela TB_USUARIO
CREATE INDEX idx_usuario_cpf ON TB_USUARIO(cpf);
CREATE INDEX idx_usuario_email ON TB_USUARIO(email);

-- Criação de índice na tabela TB_USUARIO_ATRIBUTO
CREATE INDEX idx_usuario_atributo_id_usuario ON TB_USUARIO_ATRIBUTO(id_usuario);

-- Criação de índice na tabela TB_ENDERECO
CREATE INDEX idx_endereco_logradouro ON TB_ENDERECO(ds_logradouro);
CREATE INDEX idx_endereco_id_usuario_atributo ON TB_ENDERECO(id_usuario_atributo);
CREATE INDEX idx_endereco_id_cidade ON TB_ENDERECO(id_cidade);

