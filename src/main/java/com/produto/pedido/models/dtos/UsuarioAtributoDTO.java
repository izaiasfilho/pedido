package com.produto.pedido.models.dtos;

import java.time.LocalDate;
import java.util.UUID;

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

	private UUID idUsuario;
	
	private LocalDate dataCadastro;
	
	private LocalDate dataAlteracao;
	
	
}
