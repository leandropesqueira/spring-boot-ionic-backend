package com.leandrolopes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leandrolopes.cursomc.domain.Categoria;
import com.leandrolopes.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	// dependencia automaticamente instanciada pelo spring
	@Autowired
	private CategoriaRepository repo; 
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	
}