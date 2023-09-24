package com.produto.pedido.models.dtos;

import java.util.UUID;

import com.produto.pedido.models.UsuarioAtributo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

	private UUID id;
	
	private String logradouro;
	
	private String cep;
	
	private Long numero;
	
	private String complemento;
	
	private CidadeDTO cidadeDTO;
	
	private UsuarioAtributo userAttribute;
}
