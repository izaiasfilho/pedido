package com.produto.pedido.models.dtos;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

	private UUID idProduto;

	private String descricao;
	
	private BigDecimal valor;
	
}
