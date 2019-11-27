package br.edu.sc.senai.loguinho.carrinho;

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
@RequestMapping("/api/carrinho")
public class CarrinhoService {

	private static final CarrinhoDTO [] Carr = new CarrinhoDTO[] {
	};
	
	private final CarrinhoController carrinhoController;
	
	public CarrinhoService(final CarrinhoController carinhoController) {
		this.carrinhoController = carinhoController;
		Arrays.asList(CarrinhoService.Carr).forEach(dto ->this.carrinhoController.insertCarrinho(dto));
	}

	@GetMapping("/list")
	public java.util.List<CarrinhoDTO> list(){
		return this.carrinhoController.getAllCarrinho();
	}
		
	@GetMapping("/{id}/details") 
	public ResponseEntity<CarrinhoDTO> getCarrinho (@PathVariable final Long id){
		final CarrinhoDTO carrinhoDTO = this.carrinhoController.getCarrinho(id);
		if(carrinhoDTO.equals(CarrinhoDTO.NULL_VALUE)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity<>(carrinhoDTO,HttpStatus.OK);
		}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<CarrinhoDTO> removeCarrinho (@PathVariable final Long id){
		final CarrinhoDTO removedCarrinho = this.carrinhoController.removeCarrinho(id);
		if(removedCarrinho.equals(CarrinhoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedCarrinho, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<CarrinhoDTO> updateCarrinho(@PathVariable final Long id,@RequestBody final CarrinhoDTO carrinhoDTO){
		final CarrinhoDTO oldCarrinho = this.carrinhoController.updateCarrinho(id, carrinhoDTO);
		if (oldCarrinho.equals(CarrinhoDTO.NULL_VALUE)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity<>(oldCarrinho, HttpStatus.OK);
	}
	
	@PostMapping
	public Long insertCarinho(@RequestBody final CarrinhoDTO carrinhoDTO) {
		return this.carrinhoController.insertCarrinho(carrinhoDTO);
	}
}

