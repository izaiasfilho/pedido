package com.produto.pedido.models.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.produto.pedido.models.UsuarioAtributo;

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
    private UsuarioAtributoDTO usuarioAtributoDTO;
    private List<UsuarioAtributo> listaUsuarioAtributo;
}

