package com.produto.pedido.services.implementacoes;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.pedido.models.ProdutoModel;
import com.produto.pedido.models.dtos.ProdutoRecordDTO;
import com.produto.pedido.repositories.ProdutoRepository;
import com.produto.pedido.services.ProdutoService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ProdutoImp implements ProdutoService{

	@Autowired
	ProdutoRepository repository;
	
	@Override
	public ProdutoModel novoProduto(ProdutoRecordDTO dto) {
		var produtoModel = new ProdutoModel();
		BeanUtils.copyProperties(dto,produtoModel);
		return repository.save(produtoModel);
	}


}
