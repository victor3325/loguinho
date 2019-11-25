package Anuncio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AnuncioProdutoRepository extends CrudRepository<AnuncioProdutoEntity, Long> {
	
	
}
