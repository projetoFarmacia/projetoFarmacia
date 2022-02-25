package com.projetoFarmacia.projetoFarmacia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoFarmacia.projetoFarmacia.model.Cliente;

import antlr.collections.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>  {
	
	
	public List findAllByEmailContainingIgnoreCase(String email);
	

}
