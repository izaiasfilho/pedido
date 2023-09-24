package com.produto.pedido.services;

import java.util.List;

import com.produto.pedido.models.UsuarioAtributo;
import com.produto.pedido.models.dtos.UsuarioAtributoDTO;

public interface UsuarioAtributoService {

	public UsuarioAtributo inserir(UsuarioAtributoDTO dto);
	
	public List<UsuarioAtributoDTO> listUsuarios();
}
