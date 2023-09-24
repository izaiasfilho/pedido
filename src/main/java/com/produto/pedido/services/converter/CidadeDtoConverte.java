package com.produto.pedido.services.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.produto.pedido.models.Cidade;
import com.produto.pedido.models.dtos.CidadeDTO;
import com.produto.pedido.services.ConverteDtoService;
import com.produto.pedido.services.EstadoService;

@Component
public class CidadeDtoConverte implements ConverteDtoService<CidadeDTO, Cidade> {
	
	@Autowired
	EstadoService estadoService;

	@Override
	public Cidade converteDTOparaEntidade(CidadeDTO dto) {
		if (dto != null) {
			return Cidade.builder()
					.id(dto.getId())
					.descricaoCidade(dto.getDescricaoCidade())
					.bairro(dto.getBairro())
					.estado(estadoService.buscarPorId(dto.getEstadoDTO().getId()))
					.build();
		}
		return null;
	}

	@Override
	public CidadeDTO converteEntidadeParaDTO(Cidade cidade) {
		if (cidade != null) {
			return CidadeDTO.builder()
					.build();
		}
		return null;
	}

}
