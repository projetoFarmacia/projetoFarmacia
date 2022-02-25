package com.projetoFarmacia.projetoFarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoFarmacia.projetoFarmacia.model.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>  {
	
	
	public List<Cliente> findAllByEmailContainingIgnoreCase(String email);
	

}
