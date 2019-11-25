package PessoaJuridica;

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
@RequestMapping("/pessoajuridica")

public class PjuridicaService{
	
	private static final PessoaJuridicaDTO [] Pj = new PessoaJuridicaDTO[]{
		new PessoaJuridicaDTO(1, "nome", "responsavel", "cnpj", "telefone", "celular", "pais", "estado", "cidade", "bairro", "rua", "cep"),
		new PessoaJuridicaDTO(2, "nome", "responsavel", "cnpj", "telefone", "celular", "pais", "estado", "cidade", "bairro", "rua", "cep"),
	};
	
    private final PjuridicaController pjController;
	
	public PjuridicaService(final PjuridicaController Controller) {
		this.pjController = Controller;
		Arrays.asList(PjuridicaService.Pj).forEach(dto ->this.pjController.insertPj(dto));
	}

	@GetMapping("/list")
	public java.util.List<PessoaJuridicaDTO> list(){
		return this.pjController.getAllPj();
	}
		
	@GetMapping("/{id}/details") 
	public ResponseEntity<PessoaJuridicaDTO> getPj (@PathVariable final Long id){
		final PessoaJuridicaDTO DTO = this.pjController.getPj(id);
		if(DTO.equals(PessoaJuridicaDTO.NULL_VALUE)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity<>(DTO,HttpStatus.OK);
		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PessoaJuridicaDTO> removePj (@PathVariable final Long id){
		final PessoaJuridicaDTO removedPj = this.pjController.removePj(id);
		if(removedPj.equals(PessoaJuridicaDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedPj, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<PessoaJuridicaDTO> updatePoduto(@PathVariable final Long id,@RequestBody final PessoaJuridicaDTO pjDTO){
		final PessoaJuridicaDTO oldPj = this.pjController.updatePj(id, pjDTO);
		if (oldPj.equals(PessoaJuridicaDTO.NULL_VALUE)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity<>(oldPj, HttpStatus.OK);
	}
	
	@PostMapping
	public Long insertPj(@RequestBody final PessoaJuridicaDTO pjDTO) {
		return this.pjController.insertPj(pjDTO);
	}
	
}
