package com.produto.pedido.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Column(name = "id_usuario")
    private UUID idUsuario;

    @Column(name = "dt_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "dt_alteracao")
    private LocalDate dataAlteracao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false) 
    private Usuario user;

    @OneToMany(mappedBy = "userAttribute", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> addresses;
}
