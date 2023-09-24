package com.produto.pedido.models;

import lombok.Data;

@Data
public class Cep {
	private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

}
