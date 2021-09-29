package com.leandrolopes.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandrolopes.cursomc.domain.ItemPedido;

//objeto desse tipo realiza operaçoes de acesso a dados como, busca, alteraçao, deletar
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
