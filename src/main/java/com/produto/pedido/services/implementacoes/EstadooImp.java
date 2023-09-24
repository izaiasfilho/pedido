package com.produto.pedido.services.implementacoes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.pedido.models.Estado;
import com.produto.pedido.repositories.EstadoRepository;
import com.produto.pedido.services.EstadoService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class EstadooImp implements EstadoService{
	
	@Autowired
	EstadoRepository repository;

	@Override
	public Estado buscarPorId(UUID id) {
		return repository.findById(id).orElse(null);
	}
	


}
