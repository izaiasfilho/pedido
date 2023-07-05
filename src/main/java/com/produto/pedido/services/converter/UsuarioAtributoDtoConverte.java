package com.produto.pedido.services.converter;

import org.springframework.stereotype.Component;

import com.produto.pedido.models.UsuarioAtributoModel;
import com.produto.pedido.models.dtos.UsuarioAtributoDTO;
import com.produto.pedido.services.ConverteDtoService;

@Component
public class UsuarioAtributoDtoConverte implements ConverteDtoService<UsuarioAtributoDTO, UsuarioAtributoModel> {

	@Override
	public UsuarioAtributoModel converteDTOparaEntidade(UsuarioAtributoDTO dto) {
		if (dto != null) {
			return UsuarioAtributoModel.builder()
					.id(dto.getId() != null ? dto.getId() : null)
					.idUsuario(dto.getIdUsuario())
					.dataCadastro(dto.getDataCadastro())
					.dataAlteracao(dto.getDataAlteracao())
					.build();
		}
		return null;
	}

	@Override
	public UsuarioAtributoDTO converteEntidadeParaDTO(UsuarioAtributoModel entidade) {
		if (entidade != null) {
			return UsuarioAtributoDTO.builder()
					.id(entidade.getId() != null ? entidade.getId() : null)
					.idUsuario(entidade.getIdUsuario())
					.dataCadastro(entidade.getDataCadastro())
					.dataAlteracao(entidade.getDataAlteracao())
					.build();
		}
		return null;
	}

}
