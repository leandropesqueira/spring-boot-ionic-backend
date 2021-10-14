package com.leandrolopes.cursomc.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leandrolopes.cursomc.domain.Produto;
import com.leandrolopes.cursomc.dto.ProdutoDTO;
import com.leandrolopes.cursomc.resources.utils.URL;
import com.leandrolopes.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {			
		Produto obj = service.find(id);		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(value="nome", defaultValue = "") String nome,
			@RequestParam(value="categorias", defaultValue = "") String categorias,
			@RequestParam(value="page", defaultValue = "0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value="direction", defaultValue = "ASC") String direction) {	
		String nomeDecode = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(categorias);
		Page<Produto> list = service.search(nomeDecode, ids, page, linesPerPage, orderBy, direction);
		Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
}


//ResponseEntity encapsula/armazena varias informacoes de um resposta http para um servico Rest
//Autowired instancia automaticamente o objeto
//para saber que o id da url vai vir para o id da variável usa-se a anotacao pathvarible
// endpoint de um web service é a URL onde seu serviço pode ser acessado por uma aplicação cliente
//obter dados usa-se get / o endpoint desse metodo agora vai ser /categorias/algum id que for passado