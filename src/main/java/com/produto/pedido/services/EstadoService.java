package com.produto.pedido.services;

import java.util.UUID;

import com.produto.pedido.models.Estado;

public interface EstadoService {

	public Estado buscarPorId(UUID id);
	
}
