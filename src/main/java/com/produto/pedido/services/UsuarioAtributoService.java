package com.produto.pedido.services;

import java.util.List;

import com.produto.pedido.models.dtos.UsuarioAtributoDTO;

public interface UsuarioAtributoService {

	public UsuarioAtributoDTO novo(UsuarioAtributoDTO dto);
	
	public List<UsuarioAtributoDTO> listUsuarios();
}
