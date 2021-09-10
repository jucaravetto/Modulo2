package com.lojadegames.lojadegames.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojadegames.lojadegames.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{

	List<ProdutoModel> findAllByNomeContainingIgnoreCase (String nome);
	//acho que tá ok
}
