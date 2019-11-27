package br.edu.sc.senai.loguinho.carrinho;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CarrinhoRepository extends CrudRepository<CarrinhoEntity, Long>{
	
}
