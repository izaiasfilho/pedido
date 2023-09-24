package com.produto.pedido.services.implementacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.pedido.models.Usuario;
import com.produto.pedido.models.UsuarioAtributo;
import com.produto.pedido.models.dtos.EnderecoDTO;
import com.produto.pedido.models.dtos.UsuarioAtributoDTO;
import com.produto.pedido.models.dtos.UsuarioDTO;
import com.produto.pedido.repositories.UsuarioRepository;
import com.produto.pedido.services.EnderecoService;
import com.produto.pedido.services.UsuarioAtributoService;
import com.produto.pedido.services.UsuarioService;
import com.produto.pedido.services.converter.UsuarioDtoConverte;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UsuarioImp implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioDtoConverte usuarioDtoConverte;
	
	@Autowired
	private UsuarioAtributoService usuAtributoService;
	
	@Autowired
	private EnderecoService enderecoService;


	@Transactional
	@Override
	public void inserir(UsuarioDTO dto) {
		Usuario usuario = usuarioDtoConverte.converteDTOparaEntidade(dto);
		usuario =repository.save(usuario);
		
		dto.getUsuarioAtributoDTO().setUsuario(usuario);
		
		insereUsuarioAtributo(dto.getUsuarioAtributoDTO());
	}
	
	private void insereUsuarioAtributo(UsuarioAtributoDTO usuarioAtributoDTO) {
		UsuarioAtributo usuarioAtributo = usuAtributoService.inserir(usuarioAtributoDTO);
		
		insereEndereco(usuarioAtributoDTO.getListEnderecoDTO() , usuarioAtributo );
	}
	
	private void insereEndereco(List<EnderecoDTO> listaEndereco, UsuarioAtributo usuarioAtributo) {
		listaEndereco.forEach(endereco -> {
			endereco.setUserAttribute(usuarioAtributo);
			enderecoService.inserir(endereco);
		});
	}

}
