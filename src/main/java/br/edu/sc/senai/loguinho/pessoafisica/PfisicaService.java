package br.edu.sc.senai.loguinho.pessoafisica;

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
@RequestMapping("/api/pessoafisica")

public class PfisicaService {
	
	private static final PessoaFisicaDTO [] Pf = new PessoaFisicaDTO[]{
			new PessoaFisicaDTO(1, "Marcos", "Almeida", "654-564-652-84", "(047)3333-2222", "(048)98888-7777", '1', '1'),
			new PessoaFisicaDTO(2, "Luiza", "Almeida", "214-527-852-10", "(049)3241-1422", "(048)98999-4557", '2', '2'),
	};

	private final PfisicaController pfController;
	
	public PfisicaService(final PfisicaController pfController) {
		this.pfController = pfController;
		Arrays.asList(PfisicaService.Pf).forEach(dto ->this.pfController.insertPessoaFisica(dto));
	}

	@GetMapping("/lista")
	public java.util.List<PessoaFisicaDTO> list(){
		return this.pfController.getAllPessoaFisica();
	}
		
	@GetMapping("/{id}") 
	public ResponseEntity<PessoaFisicaDTO> getpf (@PathVariable final Long id){
		final PessoaFisicaDTO DTO = this.pfController.getPessoaFisica(id);
		if(DTO.equals(PessoaFisicaDTO.NULL_VALUE)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity<>(DTO,HttpStatus.OK);
		}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<PessoaFisicaDTO> removepf (@PathVariable final Long id){
		final PessoaFisicaDTO removedpf = this.pfController.removePessoaFisica(id);
		if(removedpf.equals(PessoaFisicaDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedpf, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<PessoaFisicaDTO> updatepj(@PathVariable final Long id,@RequestBody final PessoaFisicaDTO pfDTO){
		final PessoaFisicaDTO oldpf = this.pfController.updatePessoaFisica(id, pfDTO);
		if (oldpf.equals(PessoaFisicaDTO.NULL_VALUE)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity<>(oldpf, HttpStatus.OK);
	}
	
	@PostMapping
	public Long insertpf(@RequestBody final PessoaFisicaDTO pfDTO) {
		return this.pfController.insertPessoaFisica(pfDTO);
	}
	

}


