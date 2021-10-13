package com.leandrolopes.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leandrolopes.cursomc.domain.Categoria;
import com.leandrolopes.cursomc.domain.Produto;

//objeto desse tipo realiza operaçoes de acesso a dados como, busca, alteraçao, deletar
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	@Transactional(readOnly=true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
}
