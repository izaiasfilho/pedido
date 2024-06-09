package com.softeasy.set_oes_back.controlles;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softeasy.set_oes_back.models.ProdutoModel;
import com.softeasy.set_oes_back.models.dtos.ProdutoRecordDTO;
import com.softeasy.set_oes_back.repositories.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
public class ProdutoController {

	@Autowired
	ProdutoRepository repository;
	
	@PostMapping("/produtos")
	public ResponseEntity<ProdutoModel> saveProduto(@RequestBody @Valid ProdutoRecordDTO dto){
 		var produtoModel = new ProdutoModel();
		BeanUtils.copyProperties(dto,produtoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produtoModel));
	}
}
