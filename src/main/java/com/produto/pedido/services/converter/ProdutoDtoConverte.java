package com.produto.pedido.services.converter;

import org.springframework.stereotype.Component;

import com.produto.pedido.models.ProdutoModel;
import com.produto.pedido.models.dtos.ProdutoDTO;
import com.produto.pedido.services.ConverteDtoService;

@Component
public class ProdutoDtoConverte implements ConverteDtoService<ProdutoDTO, ProdutoModel> {

	@Override
	public ProdutoModel converteDTOparaEntidade(ProdutoDTO dto) {
		if (dto != null) {
			return ProdutoModel.builder()
					.idProduto(dto.getIdProduto() != null ? dto.getIdProduto() : null)
					.descricao(dto.getDescricao())
					.codigEan(dto.getCodigEan())
					.codigo(dto.getCodigo())
					.valorVenda(dto.getValorVenda())
					.valorCusto(dto.getValorCusto())
					.valorCompra(dto.getValorCompra())
					.estoque(dto.getEstoque())
					.dataCadastro(dto.getDataCadastro())
					.dataAlteracao(dto.getDataAlteracao())
					.build();
		}
		return null;
	}

	@Override
	public ProdutoDTO converteEntidadeParaDTO(ProdutoModel entidade) {
		if (entidade != null) {
			return ProdutoDTO.builder()
					.idProduto(entidade.getIdProduto() != null ? entidade.getIdProduto() : null)
					.descricao(entidade.getDescricao())
					.codigEan(entidade.getCodigEan())
					.codigo(entidade.getCodigo())
					.valorVenda(entidade.getValorVenda())
					.valorCusto(entidade.getValorCusto())
					.valorCompra(entidade.getValorCompra())
					.estoque(entidade.getEstoque())
					.dataCadastro(entidade.getDataCadastro())
					.dataAlteracao(entidade.getDataAlteracao())
					.build();
		}
		return null;
	}

}
