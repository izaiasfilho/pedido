package com.produto.pedido.services.implementacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.pedido.models.UsuarioModel;
import com.produto.pedido.models.dtos.UsuarioDTO;
import com.produto.pedido.repositories.UsuarioRepository;
import com.produto.pedido.services.UsuarioService;
import com.produto.pedido.services.converter.UsuarioDtoConverte;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UsuarioImp implements UsuarioService{

	@Autowired
	UsuarioRepository repository;
	
	
	@Autowired
	private UsuarioDtoConverte usuarioDtoConverte;
	
	@Override
	public UsuarioDTO novoUsuario(UsuarioDTO dto) {
		UsuarioModel usuario = repository.save(usuarioDtoConverte.converteDTOparaEntidade(dto));
		return usuarioDtoConverte.converteEntidadeParaDTO(usuario);
	}


}
