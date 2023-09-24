package com.produto.pedido.services;

import com.produto.pedido.models.Cidade;
import com.produto.pedido.models.dtos.CidadeDTO;

public interface CidadeService {

	public Cidade inserir(CidadeDTO cidadeDTO);
	
}
