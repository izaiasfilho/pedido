package com.produto.pedido.services.implementacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.pedido.models.Endereco;
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
	private EnderecoDtoConverte enderecoDtoConverte;
	
	@Override
	public EnderecoDTO novo(EnderecoDTO dto) {
		Endereco produuto = repository.save(enderecoDtoConverte.converteDTOparaEntidade(dto));
		return enderecoDtoConverte.converteEntidadeParaDTO(produuto);
	}

	@Override
	public List<EnderecoDTO> listEndereco() {
		return null;
	}


}
