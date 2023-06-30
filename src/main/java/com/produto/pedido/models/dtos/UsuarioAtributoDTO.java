package com.produto.pedido.models.dtos;

import java.time.LocalDateTime;
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
	 private Long id;

	    private LocalDateTime dataCadastro;

	    private LocalDateTime dataAlteracao;

	    private UUID usuarioId;
	    
	    private UUID usuarioLogadoId;
		
}
