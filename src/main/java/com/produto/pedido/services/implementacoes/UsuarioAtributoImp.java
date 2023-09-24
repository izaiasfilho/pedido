package com.produto.pedido.services.implementacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.pedido.models.dtos.UsuarioAtributoDTO;
import com.produto.pedido.repositories.UsuarioAtributoRepository;
import com.produto.pedido.services.UsuarioAtributoService;
import com.produto.pedido.services.converter.UsuarioAtributoDtoConverte;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UsuarioAtributoImp implements UsuarioAtributoService{

	@Autowired
	UsuarioAtributoRepository repository;
	
	
	@Autowired
	private UsuarioAtributoDtoConverte usuarioAtributoDtoConverte;
	
	@Override
	public void inserir(UsuarioAtributoDTO dto) {
		repository.save(usuarioAtributoDtoConverte.converteDTOparaEntidade(dto));
	}

	@Override
	public List<UsuarioAtributoDTO> listUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}


}
