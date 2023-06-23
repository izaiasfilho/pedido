package com.produto.pedido.services;

public interface ConverteDtoService<T,A> {

	A converteDTOparaEntidade(T dto);
    T converteEntidadeParaDTO(A entidade);
}
