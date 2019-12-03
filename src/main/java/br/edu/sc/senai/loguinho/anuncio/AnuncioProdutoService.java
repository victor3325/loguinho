package br.edu.sc.senai.loguinho.anuncio;

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
@RequestMapping("/api/anuncio")
public class AnuncioProdutoService {
	
			
	private static final AnuncioProdutoDTO[] Anuncio = new AnuncioProdutoDTO[] {
	};
	
	private final AnuncioProdutoController anuncioController;
	
	public AnuncioProdutoService(final AnuncioProdutoController anuncioController) {
		this.anuncioController = anuncioController;
		Arrays.asList(AnuncioProdutoService.Anuncio).forEach(dto ->this.anuncioController.insertProduto(dto));
	}

	@GetMapping("/lista")
	public java.util.List<AnuncioProdutoDTO> list(){
		return this.anuncioController.getAllProduto();
	}
		
	@GetMapping("/{id}/detalhes") 
	public ResponseEntity<AnuncioProdutoDTO> getProduto (@PathVariable final Long id){
		final AnuncioProdutoDTO anuncioDTO = this.anuncioController.getProduto(id);
		
			return new ResponseEntity<>(anuncioDTO,HttpStatus.OK);
		}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<AnuncioProdutoDTO> removeProduto (@PathVariable final Long id){
		final AnuncioProdutoDTO removedProduto = this.anuncioController.removeProdutoDTO(id);
		if(removedProduto.equals(AnuncioProdutoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedProduto, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<AnuncioProdutoDTO> updatePoduto(@PathVariable final Long id,@RequestBody final AnuncioProdutoDTO anuncioDTO){
		final AnuncioProdutoDTO oldProduto = this.anuncioController.updateProduto(id, anuncioDTO);
		if (oldProduto.equals(AnuncioProdutoDTO.NULL_VALUE)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity<>(oldProduto, HttpStatus.OK);
	}
	
	@PostMapping
	public Long insertProduto(@RequestBody final AnuncioProdutoDTO anuncioDTO) {
		return this.anuncioController.insertProduto(anuncioDTO);
	}
	
}
