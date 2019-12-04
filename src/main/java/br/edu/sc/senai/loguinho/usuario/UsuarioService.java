package br.edu.sc.senai.loguinho.usuario;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioService {

	private static final UsuarioDTO[] Usuario = new UsuarioDTO[] {
			new UsuarioDTO(1, "marcos", "marcos@gmail.com", "senha123"),
			new UsuarioDTO(2, "luiza", "luiza@gmail.com", "senha123"),
	};
	
	private final UsuarioController usuarioController;
	
	public UsuarioService(final UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
		Arrays.asList(UsuarioService.Usuario).forEach(dto ->this.usuarioController.insertUsuario(dto));
	}

	@GetMapping("/lista")
	public java.util.List<UsuarioDTO> list(){
		return this.usuarioController.getAllUsuario();
	}
		
	@GetMapping("/{id}") 
	public ResponseEntity<UsuarioDTO> getUsuario (@PathVariable final Long id){
		final UsuarioDTO usuarioDTO = this.usuarioController.getUsuario(id);
		if(usuarioDTO.equals(UsuarioDTO.NULL_VALUE)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity<>(usuarioDTO,HttpStatus.OK);
		}
	
	@DeleteMapping("/deletar{id}")
	public ResponseEntity<UsuarioDTO> removeUsuario (@PathVariable final Long id){
		final UsuarioDTO removedUsuario = this.usuarioController.removeUsuario(id);
		if(removedUsuario.equals(UsuarioDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedUsuario, HttpStatus.OK);
	}
	@PutMapping("/update{id}")
	public ResponseEntity<UsuarioDTO> updatePoduto(@PathVariable final Long id,@RequestBody final UsuarioDTO usuarioDTO){
		final UsuarioDTO oldUsuario = this.usuarioController.updateUsuario(id, usuarioDTO);
		if (oldUsuario.equals(UsuarioDTO.NULL_VALUE)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity<>(oldUsuario, HttpStatus.OK);
	}
	
	@PostMapping
	public Long insertUsuario(@RequestBody final UsuarioDTO usuarioDTO) {
		return this.usuarioController.insertUsuario(usuarioDTO);
	}

}
