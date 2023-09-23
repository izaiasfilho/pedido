package com.produto.pedido.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.produto.pedido.models.dtos.EnderecoDTO;
import com.produto.pedido.services.EnderecoService;

import jakarta.validation.Valid;

@RestController
public class EnderecoController {

	@Autowired
	EnderecoService service;
	
	@PostMapping("/endereco")
	public ResponseEntity<EnderecoDTO> save(@RequestBody @Valid EnderecoDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.novo(dto));
	}
}
