package com.produto.pedido.services;

import com.produto.pedido.models.ProdutoModel;
import com.produto.pedido.models.dtos.ProdutoRecordDTO;

public interface ProdutoService {

	public ProdutoModel novoProduto(ProdutoRecordDTO dto);
}
