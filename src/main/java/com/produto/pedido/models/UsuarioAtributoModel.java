package com.produto.pedido.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TB_USUARIO_ATRIBUTO")
public class UsuarioAtributoModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idProduto;
	
	@Column(name= "cod_ean")
	private String codigEan;
	
	@Column(name= "cod_produto")
	private String codigo;
	
	@Column(name="ds_produto")
	private String descricao;
	
	@Column(name="vl_venda")
	private BigDecimal valorVenda;
	
	@Column(name="vl_compra")
	private BigDecimal valorCompra;

	@Column(name="vl_custo")
	private BigDecimal valorCusto;
	
	@Column(name="qtd_estoque")
	private BigDecimal estoque;
	
	@Column(name = "dt_cadastro")
	private LocalDate dataCadastro;
	
	@Column(name = "dt_alteracao")
	private LocalDate dataAlteracao;
}
