package com.produto.pedido.services.implementacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.pedido.models.Cidade;
import com.produto.pedido.models.dtos.CidadeDTO;
import com.produto.pedido.repositories.CidadeRepository;
import com.produto.pedido.services.CidadeService;
import com.produto.pedido.services.converter.CidadeDtoConverte;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CidadecoImp implements CidadeService{
	
	@Autowired
	CidadeRepository repository;
	
	@Autowired
	CidadeDtoConverte converter;

	@Override
	public Cidade inserir(CidadeDTO cidadeDTO) {
		return repository.save(converter.converteDTOparaEntidade(cidadeDTO));
	}


}
