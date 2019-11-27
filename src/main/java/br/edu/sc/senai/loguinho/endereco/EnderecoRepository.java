package br.edu.sc.senai.loguinho.endereco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EnderecoRepository extends CrudRepository<EnderecoEntity, Long>{

}
