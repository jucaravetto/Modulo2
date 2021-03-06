package com.lojadegames.lojadegames.model;

import javax.persistence.Entity; //ok
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CategoriaModel {

	public @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idCategoria;
	public @NotBlank String nome;
	public @NotBlank String descricao;
}
