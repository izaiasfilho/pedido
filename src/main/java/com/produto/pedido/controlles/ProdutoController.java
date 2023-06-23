package com.produto.pedido.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.produto.pedido.models.ProdutoModel;
import com.produto.pedido.models.dtos.ProdutoRecordDTO;
import com.produto.pedido.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
public class ProdutoController {

	@Autowired
	ProdutoService service;
	
	@PostMapping("/produtos")
	public ResponseEntity<ProdutoModel> saveProduto(@RequestBody @Valid ProdutoRecordDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.novoProduto(dto));
	}
}
