package com.leandrolopes.cursomc.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.leandrolopes.cursomc.domain.Cliente;
import com.leandrolopes.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {			
		Cliente obj = service.find(id);		
		return ResponseEntity.ok().body(obj);
	}
}


//ResponseEntity encapsula/armazena varias informacoes de um resposta http para um servico Rest
//Autowired instancia automaticamente o objeto
//para saber que o id da url vai vir para o id da variável usa-se a anotacao pathvarible
// endpoint de um web service é a URL onde seu serviço pode ser acessado por uma aplicação cliente
//obter dados usa-se get / o endpoint desse metodo agora vai ser /categorias/algum id que for passado