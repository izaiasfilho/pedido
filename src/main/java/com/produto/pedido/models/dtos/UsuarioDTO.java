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
public class UsuarioDTO {
private UUID id;
	
	private String nome;
	
	private String cpf;
	
	private String email;

	private LocalDate dataNascimento;
	
	private Boolean status;
	
		
}
