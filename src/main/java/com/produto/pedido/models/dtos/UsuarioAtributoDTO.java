package com.produto.pedido.models.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioAtributoDTO {

	private UUID idProduto;

	@NotNull
	@Pattern(regexp = "\\d{13}")
	private String codigEan;
	
	private String codigo;
	
	@NotNull
	private String descricao;
	
	private BigDecimal valorVenda;
	
	private BigDecimal valorCompra;

	private BigDecimal valorCusto;
	
	private BigDecimal estoque;
	
	private LocalDate dataCadastro;
	
	private LocalDate dataAlteracao;
	
}
