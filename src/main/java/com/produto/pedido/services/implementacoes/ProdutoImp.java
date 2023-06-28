package com.produto.pedido.services.implementacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.pedido.models.ProdutoModel;
import com.produto.pedido.models.dtos.ProdutoDTO;
import com.produto.pedido.repositories.ProdutoRepository;
import com.produto.pedido.services.ProdutoService;
import com.produto.pedido.services.converter.ProdutoDtoConverte;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ProdutoImp implements ProdutoService{

	@Autowired
	ProdutoRepository repository;
	
	
	@Autowired
	private ProdutoDtoConverte produtoDtoConverte;
	
	@Override
	public ProdutoDTO novoProduto(ProdutoDTO dto) {
		ProdutoModel produuto = repository.save(produtoDtoConverte.converteDTOparaEntidade(dto));
		return produtoDtoConverte.converteEntidadeParaDTO(produuto);
	}


}
