package com.produto.pedido.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produto.pedido.models.Cep;
import com.produto.pedido.services.LocalizadorCEPService;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    LocalizadorCEPService service;

    @GetMapping("/{cep}")
    public ResponseEntity<Cep> buscarEnderecoPorCEP(@PathVariable String cep) {
        Cep endereco = service.buscarEnderecoPorCEP(cep);
        if (endereco != null) {
            return ResponseEntity.ok(endereco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

