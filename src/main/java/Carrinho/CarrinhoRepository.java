package Carrinho;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CarrinhoRepository extends CrudRepository<CarrinhoEntity, Long>{
	
}
