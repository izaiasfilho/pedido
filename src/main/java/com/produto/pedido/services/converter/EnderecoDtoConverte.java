package com.produto.pedido.services.converter;

import org.springframework.stereotype.Component;

import com.produto.pedido.models.Endereco;
import com.produto.pedido.models.dtos.EnderecoDTO;
import com.produto.pedido.services.ConverteDtoService;

@Component
public class EnderecoDtoConverte implements ConverteDtoService<EnderecoDTO, Endereco> {

	@Override
	public Endereco converteDTOparaEntidade(EnderecoDTO dto) {
		if (dto != null) {
			return Endereco.builder()
					.id(dto.getId() != null ? dto.getId() : null)
					.logradouro(dto.getLogradouro())
					.complemento(dto.getComplemento())
					.numero(dto.getNumero())
					.build();
		}
		return null;
	}

	@Override
	public EnderecoDTO converteEntidadeParaDTO(Endereco entidade) {
		if (entidade != null) {
			return EnderecoDTO.builder()
					.id(entidade.getId() != null ? entidade.getId() : null)
					.logradouro(entidade.getLogradouro())
					.complemento(entidade.getComplemento())
					.numero(entidade.getNumero())
					.build();
		}
		return null;
	}

}
