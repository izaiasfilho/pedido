package com.produto.pedido.models.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
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

	private String codigEan;
	
	private String codigo;
	
	private String descricao;
	
	private BigDecimal valorVenda;
	
	private BigDecimal valorCompra;

	private BigDecimal valorCusto;
	
	private BigDecimal estoque;
	
	private LocalDate dataCadastro;
	
	private LocalDate dataAlteracao;
	
}
