package com.produto.pedido.services;

import java.util.List;

import com.produto.pedido.models.dtos.EnderecoDTO;

public interface EnderecoService {

	public void inserir(EnderecoDTO enderecoDTO);
	
	public List<EnderecoDTO> listEndereco();
}
