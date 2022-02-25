package com.projetoFarmacia.projetoFarmacia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoFarmacia.projetoFarmacia.model.Categoria;

import antlr.collections.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	
	public List findAllBytipoProdutoContainingIgnoreCase(String tipoProduto);
	

}
