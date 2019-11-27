package br.edu.sc.senai.loguinho.pessoafisica;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PfisicaRepository extends CrudRepository<PfisicaEntity,Long>{

}
