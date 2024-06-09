package com.softeasy.set_oes_back.models.dtos;



import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRecordDTO(@NotBlank String descricao, @NotNull BigDecimal valor) {

}
