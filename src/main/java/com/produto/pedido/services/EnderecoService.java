package com.produto.pedido.services;

import java.util.List;

import com.produto.pedido.models.dtos.EnderecoDTO;

public interface EnderecoService {

	public EnderecoDTO novo(EnderecoDTO dto);
	
	public List<EnderecoDTO> listEndereco();
}
