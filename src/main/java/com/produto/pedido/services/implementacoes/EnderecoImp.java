package com.produto.pedido.services.implementacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.pedido.models.dtos.EnderecoDTO;
import com.produto.pedido.repositories.EnderecoRepository;
import com.produto.pedido.services.EnderecoService;
import com.produto.pedido.services.converter.EnderecoDtoConverte;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class EnderecoImp implements EnderecoService{

	@Autowired
	EnderecoRepository repository;
	
	@Autowired
	EnderecoDtoConverte endercoDtoConverte;
	
	@Override
	public void inserir(EnderecoDTO enderecoDTO) {
	 repository.save(endercoDtoConverte.converteDTOparaEntidade(enderecoDTO));
	}

	@Override
	public List<EnderecoDTO> listEndereco() {
		return null;
	}




}
