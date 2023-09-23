package com.produto.pedido.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produto.pedido.models.UsuarioAtributo;

public interface UsuarioAtributoRepository extends JpaRepository<UsuarioAtributo, UUID>{

}
