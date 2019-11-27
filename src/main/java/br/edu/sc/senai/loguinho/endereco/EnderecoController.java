package br.edu.sc.senai.loguinho.endereco;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;


@Controller
public class EnderecoController {
	
	private final EnderecoRepository enderecoRepository;

	EnderecoController(final EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	private static void updateEntityFromDTO(final EnderecoDTO enderecoDTO, final EnderecoEntity enderecoEntity) {
		
		enderecoEntity.setId(enderecoDTO.getId());;
		enderecoEntity.setPais(enderecoDTO.getPais());
		enderecoEntity.setEstado(enderecoDTO.getEstado());
		enderecoEntity.setCidade(enderecoDTO.getCidade());
		enderecoEntity.setBairro(enderecoDTO.getBairro());
		enderecoEntity.setRua(enderecoDTO.getRua());
		enderecoEntity.setCep(enderecoDTO.getCep());
		
		
	}

	private static EnderecoEntity toEntity(final EnderecoDTO enderecoDTO) {
		
		final long id = enderecoDTO.getId();
		final String pais = enderecoDTO.getPais();
		final String estado = enderecoDTO.getEstado();
		final String cidade = enderecoDTO.getCidade();
		final String bairro = enderecoDTO.getBairro();
		final String rua= enderecoDTO.getRua();
		final String cep = enderecoDTO.getCep();
		
		return new EnderecoEntity(id, pais, estado, cidade, bairro, rua, cep);
	}

	private static EnderecoDTO toDTO(final EnderecoEntity enderecoEntity) {

		final long id = enderecoEntity.getId();
		final String pais = enderecoEntity.getPais();
		final String estado = enderecoEntity.getEstado();
		final String cidade = enderecoEntity.getCidade();
		final String bairro = enderecoEntity.getBairro();
		final String rua= enderecoEntity.getRua();
		final String cep = enderecoEntity.getCep();
		
		return new EnderecoDTO(id, pais, estado, cidade, bairro, rua, cep);
	}

	/*private boolean isNotExistsProductByIdentifier(final Long id) {
		// TODO Auto-generated method stub
		return !this.enderecoRepository.existsById(id);
	}*/

	List<EnderecoDTO> getAllEndereco() {
		final List<EnderecoDTO> enderecoDTO = new ArrayList<>();
		this.enderecoRepository.findAll().forEach(enderecoEntity -> enderecoDTO.add(EnderecoController.toDTO(enderecoEntity)));
		return enderecoDTO;
	}

	EnderecoDTO getEndereco(final Long id) {
		final Optional<EnderecoEntity> optionalEndereco = this.enderecoRepository.findById(id);
		if (optionalEndereco.isPresent()) {
			return EnderecoController.toDTO(optionalEndereco.get());
		}
		return EnderecoDTO.NULL_VALUE;
	}

	EnderecoDTO removeEndereco(final Long id) {
		final Optional<EnderecoEntity> optionalEndereco = this.enderecoRepository.findById(id);
		if (optionalEndereco.isPresent()) {
			final EnderecoEntity enderecoEntity = optionalEndereco.get();
			this.enderecoRepository.delete(enderecoEntity);
			return EnderecoController.toDTO(enderecoEntity);
		}
		return EnderecoDTO.NULL_VALUE;
	}

	Long insertEndereco(final EnderecoDTO enderecoDTO) {
		final EnderecoEntity enderecoEntity = EnderecoController.toEntity(enderecoDTO);
		this.enderecoRepository.save(enderecoEntity);
		return enderecoEntity.getId();
	}

	EnderecoDTO updateEndereco(final Long id, final EnderecoDTO enderecoDTO) {
		final Optional<EnderecoEntity> optionalEndereco = this.enderecoRepository.findById(id);
		if (optionalEndereco.isPresent()) {
			final EnderecoEntity enderecoEntity = optionalEndereco.get();
			final EnderecoDTO oldEndereco = EnderecoController.toDTO(enderecoEntity);
			EnderecoController.updateEntityFromDTO(enderecoDTO, enderecoEntity);
			this.enderecoRepository.save(enderecoEntity);
			return oldEndereco;
		}
		return EnderecoDTO.NULL_VALUE;
		
	}

}
