package com.produto.pedido.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.produto.pedido.models.dtos.UsuarioAtributoDTO;
import com.produto.pedido.services.UsuarioAtributoService;

import jakarta.validation.Valid;

@RestController
public class UsuarioAtributoController {

	@Autowired
	UsuarioAtributoService service;
	
	@PostMapping("/usuarioatributo")
	public ResponseEntity<UsuarioAtributoDTO> save(@RequestBody @Valid UsuarioAtributoDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.novo(dto));
	}
}
