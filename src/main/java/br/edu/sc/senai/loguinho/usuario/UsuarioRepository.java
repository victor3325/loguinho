package br.edu.sc.senai.loguinho.usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

}
