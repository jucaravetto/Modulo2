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

import com.lojadegames.lojadegames.Repository.CategoriaRepository;
import com.lojadegames.lojadegames.model.CategoriaModel;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired private CategoriaRepository repository;
	
	@GetMapping("pegarTodos")
	public ResponseEntity<List<CategoriaModel>> getAll(){
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@GetMapping("/pegarPorId/{id}")
	public ResponseEntity<CategoriaModel> getById(@PathVariable (value = "id")Long idCategoria){
		Optional<CategoriaModel> objetoCategoria = repository.findById(idCategoria);
		if(objetoCategoria.isPresent()) {
			return ResponseEntity.status(200).body(objetoCategoria.get());
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@GetMapping("buscaPorDescricao/{descricao}")
	public ResponseEntity<List<CategoriaModel>> buscaPorDescricao(@PathVariable(value = "descricao")String descricao){
		return ResponseEntity.status(200).body(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	} //Fazer o tratamento com if else aqui igual ao de cima
	
	@PostMapping("/postarCategoria")
	public ResponseEntity<CategoriaModel> salvar(@Valid @RequestBody CategoriaModel salvarCategoria){
		return ResponseEntity.status(201).body(repository.save(salvarCategoria));
	}
	
	@PutMapping("/atualizarCategoria")
	public ResponseEntity<CategoriaModel> atualizarCategoria (@Valid @RequestBody CategoriaModel atualizarCategoria){
		return ResponseEntity.status(201).body(repository.save(atualizarCategoria));
	}
	
	@DeleteMapping
	public void deletarCategoria(@PathVariable(value = "id") Long idCategoria) {
		repository.deleteById(idCategoria);
	}
}





