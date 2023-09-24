package com.produto.pedido.models.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.produto.pedido.models.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioAtributoDTO {

	private UUID id;

	private Usuario usuario;
	
	private LocalDate dataCadastro;
	
	private LocalDate dataAlteracao;
	
	private List<EnderecoDTO> listEnderecoDTO;
}
