package br.edu.sc.senai.loguinho.pessoa;

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

import br.edu.sc.senai.loguinho.pessoa.PessoaController;
import br.edu.sc.senai.loguinho.pessoa.PessoaDTO;
import br.edu.sc.senai.loguinho.pessoa.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaService {
	
private static final PessoaDTO[] Pessoa = new PessoaDTO[] {
		
};

private final PessoaController pessoaController;

public PessoaService(final PessoaController pessoaController) {
	this.pessoaController = pessoaController;
	Arrays.asList(PessoaService.Pessoa).forEach(dto ->this.pessoaController.insertPessoa(dto));
}

@GetMapping("/lista")
public java.util.List<PessoaDTO> list(){
	return this.pessoaController.getAllPessoa();
}
	
@GetMapping("/{id}/detalhes") 
public ResponseEntity<PessoaDTO> getPessoa (@PathVariable final Long id){
	final PessoaDTO pessoaDTO = this.pessoaController.getPessoa(id);
	
		return new ResponseEntity<>(pessoaDTO,HttpStatus.OK);
	}

@DeleteMapping("/deletar/{id}")
public ResponseEntity<PessoaDTO> removePessoa (@PathVariable final Long id){
	final PessoaDTO removedPessoa = this.pessoaController.removePessoa(id);
	if(removedPessoa.equals(PessoaDTO.NULL_VALUE)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(removedPessoa, HttpStatus.OK);
}
@PutMapping("/update/{id}")
public ResponseEntity<PessoaDTO> updatePoduto(@PathVariable final Long id,@RequestBody final PessoaDTO pessoaDTO){
	final PessoaDTO oldPessoa = this.pessoaController.updatePessoa(id, pessoaDTO);
	if (oldPessoa.equals(PessoaDTO.NULL_VALUE)) {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
	return new ResponseEntity<>(oldPessoa, HttpStatus.OK);
}

@PostMapping
public Long insertPessoa(@RequestBody final PessoaDTO pessoaDTO) {
	return this.pessoaController.insertPessoa(pessoaDTO);
}

}
