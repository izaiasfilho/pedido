package com.produto.pedido.services.implementacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.pedido.models.UsuarioAtributoModel;
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
	private UsuarioAtributoDtoConverte produtoDtoConverte;
	
	@Override
	public UsuarioAtributoDTO novoProduto(UsuarioAtributoDTO dto) {
		UsuarioAtributoModel produuto = repository.save(produtoDtoConverte.converteDTOparaEntidade(dto));
		return produtoDtoConverte.converteEntidadeParaDTO(produuto);
	}


}
