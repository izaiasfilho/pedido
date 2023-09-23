package com.produto.pedido.models.dtos;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoDTO {

	private UUID id;
	private String sigla;
	private String descricaoEstado;
	private List<CidadeDTO> listaCidadesDTO;
}
