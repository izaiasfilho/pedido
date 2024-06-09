CREATE TABLE IF NOT EXISTS Endereco (
    Id INT PRIMARY KEY,
    CEP VARCHAR(10),
    Rua VARCHAR(255),
    Numero VARCHAR(10),
    Complemento VARCHAR(255),
    Bairro VARCHAR(255),
    Cidade VARCHAR(255),
    Estado VARCHAR(2)
);

CREATE TABLE IF NOT EXISTS Usuario (
    Id INT PRIMARY KEY,
    Nome VARCHAR(255),
    Login VARCHAR(18),
    password VARCHAR(20),
    Status VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Cliente (
    Id INT PRIMARY KEY,
    Nome VARCHAR(255),
    CPF_CNPJ VARCHAR(18),
    RG VARCHAR(20),
    Nascimento DATETIME,
    Telefone VARCHAR(15),
    idIndereco INT,
    Status VARCHAR(50),
    FOREIGN KEY (idIndereco) REFERENCES Endereco(Id)
);

CREATE INDEX idx_Cliente_Nome ON Cliente (Nome);
CREATE INDEX idx_Cliente_Status ON Cliente (Status);

CREATE TABLE IF NOT EXISTS Forma_Pagamento (
    Id INT PRIMARY KEY,
    Descricao VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Seguimento (
    Id INT PRIMARY KEY,
    descricao VARCHAR(50)
);

CREATE INDEX idx_Seguimento_Descricao ON Seguimento (descricao);

CREATE TABLE IF NOT EXISTS Equipamento (
    Id INT PRIMARY KEY,
    Descricao VARCHAR(255),
    Caracteristica VARCHAR(255),
    Valor DECIMAL(10, 2),
    Quantidade INT,
    Tipo_Equipamento VARCHAR(50),
    Status VARCHAR(50),
    Modelo VARCHAR(50)
);

CREATE INDEX idx_Equipamento_Descricao ON Equipamento (Descricao);
CREATE INDEX idx_Equipamento_Tipo ON Equipamento (Tipo_Equipamento);

CREATE TABLE IF NOT EXISTS Status_Pagamento (
    Id INT PRIMARY KEY,
    Status VARCHAR(50)
);

CREATE INDEX idx_Status_Pagamento_Status ON Status_Pagamento (Status);

CREATE TABLE IF NOT EXISTS Retorno (
    Id INT PRIMARY KEY,
    idSeguimentos INT,
    Data DATETIME,
    Problema VARCHAR(255),
    Descricao_Servico VARCHAR(255),
    FOREIGN KEY (idSeguimentos) REFERENCES Seguimento(Id)
);

CREATE INDEX idx_Retorno_Data ON Retorno (Data);

CREATE TABLE IF NOT EXISTS Venda_Maquinas (
    idCliente INT,
    IdEquipamento INT,
    Data DATETIME,
    Valor_Total DECIMAL(10, 2),
    Valor_Parcela DECIMAL(10, 2),
    idForma_Pagamento INT,
    Observacao VARCHAR(255),
    Entrada_Caixa DECIMAL(10, 2),
    IdRetorno INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(Id),
    FOREIGN KEY (idEquipamento) REFERENCES Equipamento(Id),
    FOREIGN KEY (idForma_Pagamento) REFERENCES Forma_Pagamento(Id),
    FOREIGN KEY (IdRetorno) REFERENCES Retorno(Id)
);

CREATE INDEX idx_Venda_Maquinas_Data ON Venda_Maquinas (Data);
CREATE INDEX idx_Venda_Maquinas_Valor_Total ON Venda_Maquinas (Valor_Total);

CREATE TABLE IF NOT EXISTS Compra_Maquina (
    idCliente INT,
    idEquipamento INT,
    Valor DECIMAL(10, 2),
    Data DATETIME,
    Observacao VARCHAR(255),
    Saida_Caixa DECIMAL(10, 2),
    idForma_Pagamento INT,
    idRetorno INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(Id),
    FOREIGN KEY (idEquipamento) REFERENCES Equipamento(Id),
    FOREIGN KEY (idForma_Pagamento) REFERENCES Forma_Pagamento(Id),
    FOREIGN KEY (idRetorno) REFERENCES Retorno(Id)
);

CREATE INDEX idx_Compra_Maquina_Data ON Compra_Maquina (Data);
CREATE INDEX idx_Compra_Maquina_Valor ON Compra_Maquina (Valor);

CREATE TABLE IF NOT EXISTS Alugueis (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    idCliente INT,
    idEquipamento INT,
    Observacao VARCHAR(255),
    Data_Contrato DATETIME,
    idForma_Pagamento INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(Id),
    FOREIGN KEY (idEquipamento) REFERENCES Equipamento(Id),
    FOREIGN KEY (idForma_Pagamento) REFERENCES Forma_Pagamento(Id)
);

CREATE INDEX idx_Alugueis_Data_Contrato ON Alugueis (Data_Contrato);

CREATE TABLE IF NOT EXISTS Seguro (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    idCliente INT,
    idEquipamento INT,
    Valor_Total DECIMAL(10, 2),
    Data_Vencimento DATETIME,
    idForma_Pagamento INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(Id),
    FOREIGN KEY (idEquipamento) REFERENCES Equipamento(Id),
    FOREIGN KEY (idForma_Pagamento) REFERENCES Forma_Pagamento(Id)
);

CREATE INDEX idx_Seguro_Data_Vencimento ON Seguro (Data_Vencimento);
CREATE INDEX idx_Seguro_Valor_Total ON Seguro (Valor_Total);

CREATE TABLE IF NOT EXISTS Movimentacao_Aluguel (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    idAluguel INT,
    Data_Pagamento DATETIME,
    Valor_Pagamento DECIMAL(10, 2),
    idStatus_Pagamento INT,
    idForma_Pagamento INT,
    Valor_Idenizacao DECIMAL(10, 2),
    idRetorno INT,
    FOREIGN KEY (idAluguel) REFERENCES Alugueis(Id),
    FOREIGN KEY (idStatus_Pagamento) REFERENCES Status_Pagamento(Id),
    FOREIGN KEY (idForma_Pagamento) REFERENCES Forma_Pagamento(Id),
    FOREIGN KEY (idRetorno) REFERENCES Retorno(Id)
);

CREATE INDEX idx_Movimentacao_Aluguel_Data_Pagamento ON Movimentacao_Aluguel (Data_Pagamento);
CREATE INDEX idx_Movimentacao_Aluguel_Valor_Pagamento ON Movimentacao_Aluguel (Valor_Pagamento);

CREATE TABLE IF NOT EXISTS Movimentacao_Seguro (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    idSeguro INT,
    Data_Pagamento DATETIME,
    Valor_Pagamento DECIMAL(10, 2),
    idStatus_Pagamento INT,
    idForma_Pagamento INT,
    Valor_Idenizacao DECIMAL(10, 2),
    idRetorno INT,
    FOREIGN KEY (idSeguro) REFERENCES Seguro(Id),
    FOREIGN KEY (idStatus_Pagamento) REFERENCES Status_Pagamento(Id),
    FOREIGN KEY (idForma_Pagamento) REFERENCES Forma_Pagamento(Id),
    FOREIGN KEY (idRetorno) REFERENCES Retorno(Id)
);

CREATE INDEX idx_Movimentacao_Seguro_Data_Pagamento ON Movimentacao_Seguro (Data_Pagamento);
CREATE INDEX idx_Movimentacao_Seguro_Valor_Pagamento ON Movimentacao_Seguro (Valor_Pagamento);

CREATE TABLE IF NOT EXISTS Servico (
    idCliente INT,
    Data_Contrato DATETIME,
    Valor_Total DECIMAL(10, 2),
    idForma_Pagamento INT,
    Observacao VARCHAR(255),
    Descricao_Servico VARCHAR(255),
    idEquipamento INT,
    idRetorno INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(Id),
    FOREIGN KEY (idEquipamento) REFERENCES Equipamento(Id),
    FOREIGN KEY (idForma_Pagamento) REFERENCES Forma_Pagamento(Id),
    FOREIGN KEY (idRetorno) REFERENCES Retorno(Id)
);

CREATE INDEX idx_Servico_Data_Contrato ON Servico (Data_Contrato);
CREATE INDEX idx_Servico_Valor_Total ON Servico (Valor_Total);

CREATE TABLE IF NOT EXISTS Orcamento (
    idCliente INT,
    idSeguimentos INT,
    Taxa DECIMAL(10, 2),
    Valor DECIMAL(10, 2),
    Data DATETIME,
    Status VARCHAR(50),
    FOREIGN KEY (idCliente) REFERENCES Cliente(Id),
    FOREIGN KEY (idSeguimentos) REFERENCES Seguimento(Id)
);

CREATE INDEX idx_Orcamento_Data ON Orcamento (Data);
CREATE INDEX idx_Orcamento_Valor ON Orcamento (Valor);

CREATE TABLE IF NOT EXISTS Saida_Caixa (
    Data DATETIME,
    Valor DECIMAL(10, 2),
    Motivo VARCHAR(255)
);

CREATE INDEX idx_Saida_Caixa_Data ON Saida_Caixa (Data);
CREATE INDEX idx_Saida_Caixa_Valor ON Saida_Caixa (Valor);

CREATE TABLE IF NOT EXISTS Anexo (
    Anexos_ID INT PRIMARY KEY,
    IdSeguimento INT,
    Local_Salvo VARCHAR(255),
    Data DATETIME,
    FOREIGN KEY (IdSeguimento) REFERENCES Seguimento(Id)
);

CREATE INDEX idx_Anexo_Data ON Anexo (Data);
