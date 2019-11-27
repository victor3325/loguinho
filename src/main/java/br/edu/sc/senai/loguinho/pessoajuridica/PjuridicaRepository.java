package br.edu.sc.senai.loguinho.pessoajuridica;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PjuridicaRepository extends CrudRepository<PjuridicaEntity,Long>{

}
