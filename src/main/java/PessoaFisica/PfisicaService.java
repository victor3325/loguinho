package PessoaFisica;

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
@RequestMapping("/pessoafisica")

public class PfisicaService {
	
	private static final PessoaFisicaDTO [] Pf = new PessoaFisicaDTO[]{
			new PessoaFisicaDTO(1, "Pedro", "Heifler", "99999999999", "4799999999", "47988888888", "Brasil", "Santa Catarina", "Blumenau", "Garcia", "Pedro 2 alves", "89000-000"),
			new PessoaFisicaDTO(2, "Miguel", "Zimm", "78945613285", "4788888888", "47977777777", "Brasil", "Ascura", "Ascura Pequena", "Ascurrinha", "Dr Ascurrar", "89000-001")
	};

	private final PfisicaController pfController;
	
	public PfisicaService(final PfisicaController pfController) {
		this.pfController = pfController;
		Arrays.asList(PfisicaService.Pf).forEach(dto ->this.pfController.insertPessoaFisica(dto));
	}

	@GetMapping("/list")
	public java.util.List<PessoaFisicaDTO> list(){
		return this.pfController.getAllPessoaFisica();
	}
		
	@GetMapping("/{id}/details") 
	public ResponseEntity<PessoaFisicaDTO> getpf (@PathVariable final Long id){
		final PessoaFisicaDTO DTO = this.pfController.getPessoaFisica(id);
		if(DTO.equals(PessoaFisicaDTO.NULL_VALUE)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity<>(DTO,HttpStatus.OK);
		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PessoaFisicaDTO> removepf (@PathVariable final Long id){
		final PessoaFisicaDTO removedpf = this.pfController.removePessoaFisica(id);
		if(removedpf.equals(PessoaFisicaDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedpf, HttpStatus.OK);
	}
	@PutMapping("/{id}")
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


