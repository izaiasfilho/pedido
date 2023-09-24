package com.produto.pedido.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "TB_ENDERECO")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(name = "cep")
    private String cep;

    @Column(name = "ds_logradouro")
    private String logradouro;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "ds_complemento")
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "id_usuario_atributo")
    private UsuarioAtributo userAttribute;

    @ManyToOne
    @JoinColumn(name = "id_cidade") 
    private Cidade cidade;
}
