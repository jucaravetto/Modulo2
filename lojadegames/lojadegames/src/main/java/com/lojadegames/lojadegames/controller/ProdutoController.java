package com.lojadegames.lojadegames.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojadegames.lojadegames.Repository.ProdutoRepository;
import com.lojadegames.lojadegames.model.ProdutoModel;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired private ProdutoRepository repository;
	
	@GetMapping("/pegartodos")
	public ResponseEntity<List<ProdutoModel>> getAll(){
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@GetMapping("/pegarProdutoPorId/{id}")
	public ResponseEntity<ProdutoModel> getById(@PathVariable(value = "id") Long idProduto){
		Optional<ProdutoModel> objetoProduto = repository.findById(idProduto);
		if(objetoProduto.isPresent()) {
			return ResponseEntity.status(200).body(objetoProduto.get());
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@GetMapping("/buscaPorNome/{nome}")
	public ResponseEntity<List<ProdutoModel>> buscaPorPreco (@PathVariable(value = "nome")String nome){
		return ResponseEntity.status(200).body(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping("/postarProduto")
	public ResponseEntity<ProdutoModel> salvarProduto (@Valid @RequestBody ProdutoModel salvarProduto){
		return ResponseEntity.status(201).body(repository.save(salvarProduto));
	}
	
	@PutMapping("/atualizarProduto")
	public ResponseEntity<ProdutoModel> atualizarProduto (@Valid @RequestBody ProdutoModel atualizarProduto){
		return ResponseEntity.status(201).body(repository.save(atualizarProduto));
	}
	
	@DeleteMapping
	public void deletarProduto (@PathVariable(value = "id") Long idProduto) {
		repository.deleteById(idProduto);
	}
}
