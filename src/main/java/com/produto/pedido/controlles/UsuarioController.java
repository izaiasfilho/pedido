package com.produto.pedido.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.produto.pedido.models.dtos.UsuarioDTO;
import com.produto.pedido.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService service;
	
	@PostMapping("/usuarios")
	public ResponseEntity<Void> saveUsuario(@RequestBody @Valid UsuarioDTO dto) {
	    service.inserir(dto);
	    return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
