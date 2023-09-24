package com.produto.pedido.services.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.produto.pedido.models.UsuarioAtributo;
import com.produto.pedido.models.dtos.UsuarioAtributoDTO;
import com.produto.pedido.services.ConverteDtoService;
import com.produto.pedido.services.EnderecoService;

@Component
public class UsuarioAtributoDtoConverte implements ConverteDtoService<UsuarioAtributoDTO, UsuarioAtributo> {
	
	@Autowired
	private EnderecoService enderecoService;

	@Override
	public UsuarioAtributo converteDTOparaEntidade(UsuarioAtributoDTO dto) {
		if (dto != null) {
			
			dto.getListEnderecoDTO().forEach(endereco -> {
				enderecoService.inserir(endereco);
			});
			
			return UsuarioAtributo.builder()
					.id(dto.getId() != null ? dto.getId() : null)
					.idUsuario(dto.getUsuario() != null ? dto.getUsuario().getId() : null)
					.dataCadastro(dto.getDataCadastro())
					.dataAlteracao(dto.getDataAlteracao())
					.build();
		}
		return null;
	}

	@Override
	public UsuarioAtributoDTO converteEntidadeParaDTO(UsuarioAtributo entidade) {
		if (entidade != null) {
			return UsuarioAtributoDTO.builder()
					.id(entidade.getId() != null ? entidade.getId() : null)
					//.usuario(entidade.getUsuario())
					.dataCadastro(entidade.getDataCadastro())
					.dataAlteracao(entidade.getDataAlteracao())
					.build();
		}
		return null;
	}

}
