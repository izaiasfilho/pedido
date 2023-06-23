package com.produto.pedido.models.dtos;

import org.springframework.stereotype.Component;

import com.produto.pedido.models.ProdutoModel;
import com.produto.pedido.services.ConverteDtoService;

@Component
public class ProdutoDtoConverte implements ConverteDtoService<ProdutoDTO, ProdutoModel> {

	@Override
	public ProdutoModel converteDTOparaEntidade(ProdutoDTO dto) {
		if (dto != null) {
			return ProdutoModel.builder().idProduto(dto.getIdProduto() != null ? dto.getIdProduto() : null)
					.descricao(dto.getDescricao()).valor(dto.getValor()).build();
		}
		return null;
	}

	@Override
	public ProdutoDTO converteEntidadeParaDTO(ProdutoModel entidade) {
		if (entidade != null) {
			return ProdutoDTO.builder().idProduto(entidade.getIdProduto() != null ? entidade.getIdProduto() : null)
					.descricao(entidade.getDescricao()).valor(entidade.getValor()).build();
		}
		return null;
	}

}
