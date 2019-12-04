package br.edu.sc.senai.loguinho.pessoa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PessoaRepository extends CrudRepository<PessoaEntity,Long>{
	
}
