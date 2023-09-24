package com.produto.pedido.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "TB_USUARIO_ATRIBUTO")
public class UsuarioAtributo implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "dt_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "dt_alteracao")
    private LocalDate dataAlteracao;

    @Column(name = "id_usuario")
    private UUID idUsuario;

    @OneToMany(mappedBy = "userAttribute", orphanRemoval = true)
    private List<Endereco> enderecos;
}
