package com.produto.pedido.models.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CidadeDTO {

    private UUID id;
    private String descricaoCidade;
    private String bairro;
    private EstadoDTO estadoDTO;
}
