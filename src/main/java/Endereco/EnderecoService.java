package Endereco;

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
@RequestMapping("/endereco")
public class EnderecoService {
	
	private static final EnderecoDTO[] Endereco = new EnderecoDTO[] {
			new EnderecoDTO(1, "pais", "estado", "cidade", "bairro", "rua", "cep"),
			new EnderecoDTO(2, "pais2", "estado2", "cidade2", "bairro2", "rua2", "cep2")
	};
	
	private final EnderecoController enderecoController;
	
	public EnderecoService(final EnderecoController enderecoController) {
		this.enderecoController = enderecoController;
		Arrays.asList(EnderecoService.Endereco).forEach(dto ->this.enderecoController.insertEndereco(dto));
	}

	@GetMapping("/list")
	public java.util.List<EnderecoDTO> list(){
		return this.enderecoController.getAllEndereco();
	}
		
	@GetMapping("/{id}/details") 
	public ResponseEntity<EnderecoDTO> getEndereco (@PathVariable final Long id){
		final EnderecoDTO enderecoDTO = this.enderecoController.getEndereco(id);
		if(enderecoDTO.equals(EnderecoDTO.NULL_VALUE)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity<>(enderecoDTO,HttpStatus.OK);
		}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<EnderecoDTO> removeEndereco (@PathVariable final Long id){
		final EnderecoDTO removedEndereco = this.enderecoController.removeEndereco(id);
		if(removedEndereco.equals(EnderecoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedEndereco, HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<EnderecoDTO> updatePoduto(@PathVariable final Long id,@RequestBody final EnderecoDTO enderecoDTO){
		final EnderecoDTO oldEndereco = this.enderecoController.updateEndereco(id, enderecoDTO);
		if (oldEndereco.equals(EnderecoDTO.NULL_VALUE)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity<>(oldEndereco, HttpStatus.OK);
	}
	
	@PostMapping
	public Long insertEndereco(@RequestBody final EnderecoDTO enderecoDTO) {
		return this.enderecoController.insertEndereco(enderecoDTO);
	}

}
