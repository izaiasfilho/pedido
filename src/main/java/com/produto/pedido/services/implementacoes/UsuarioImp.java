package com.produto.pedido.services.implementacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.pedido.models.Usuario;
import com.produto.pedido.models.dtos.UsuarioDTO;
import com.produto.pedido.repositories.UsuarioRepository;
import com.produto.pedido.services.UsuarioAtributoService;
import com.produto.pedido.services.UsuarioService;
import com.produto.pedido.services.converter.UsuarioDtoConverte;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UsuarioImp implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioDtoConverte usuarioDtoConverte;
	
	@Autowired
	private UsuarioAtributoService usuAtributoService;


	@Transactional
	@Override
	public void inserir(UsuarioDTO dto) {
		Usuario usuario = usuarioDtoConverte.converteDTOparaEntidade(dto);
		usuario =repository.save(usuario);
		
		dto.getUsuarioAtributoDTO().setUsuario(usuario);
		usuAtributoService.inserir(dto.getUsuarioAtributoDTO());
	}

}
