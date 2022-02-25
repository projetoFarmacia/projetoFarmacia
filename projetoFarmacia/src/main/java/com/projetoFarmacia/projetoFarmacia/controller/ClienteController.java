package com.projetoFarmacia.projetoFarmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoFarmacia.projetoFarmacia.Repository.CategoriaRepository;
import com.projetoFarmacia.projetoFarmacia.Repository.ClienteRepository;
import com.projetoFarmacia.projetoFarmacia.model.Cliente;




@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("email/{email}")
	public ResponseEntity<antlr.collections.List> GetByEmail(@PathVariable String email){
		return ResponseEntity.ok(repository.findAllByEmailContainingIgnoreCase(email));
	}
	 
	@PostMapping
		public ResponseEntity<Cliente> post (@RequestBody Cliente cliente){
			return ResponseEntity.status(HttpStatus.CREATED).body(ClienteRepository.save(cliente));
	}
	

    @PutMapping
    public ResponseEntity<Cliente> put (@RequestBody Cliente cliente){
    	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
    }
    
    @DeleteMapping("/{id}")
	public void delete(@PathVariable long id){
		repository.deleteById(id);
	}
	
	
	
}
