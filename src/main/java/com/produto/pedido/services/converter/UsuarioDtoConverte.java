package com.produto.pedido.services.converter;

import org.springframework.stereotype.Component;

import com.produto.pedido.models.UsuarioModel;
import com.produto.pedido.models.dtos.UsuarioDTO;
import com.produto.pedido.services.ConverteDtoService;

@Component
public class UsuarioDtoConverte implements ConverteDtoService<UsuarioDTO, UsuarioModel> {

	@Override
	public UsuarioModel converteDTOparaEntidade(UsuarioDTO dto) {
		if (dto != null) {
			return UsuarioModel.builder()
					.id(dto.getId() != null ? dto.getId() : null)
					.nome(dto.getNome())
					.cpf(dto.getCpf())
					.dataNascimento(dto.getDataNascimento())
					.email(dto.getEmail())
					.status(dto.getStatus())
					.build();
		}
		return null;
	}

	@Override
	public UsuarioDTO converteEntidadeParaDTO(UsuarioModel entidade) {
		if (entidade != null) {
			return UsuarioDTO.builder()
					.id(entidade.getId()!= null ? entidade.getId() : null)
					.nome(entidade.getNome())
					.cpf(entidade.getCpf())
					.dataNascimento(entidade.getDataNascimento())
					.email(entidade.getEmail())
					.status(entidade.getStatus())
					.build();
		}
		return null;
	}

}
