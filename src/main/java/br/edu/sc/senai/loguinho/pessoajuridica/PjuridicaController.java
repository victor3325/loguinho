package br.edu.sc.senai.loguinho.pessoajuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
public class PjuridicaController {
	private final PjuridicaRepository pjRepository;

	public PjuridicaController(final PjuridicaRepository pjRepository) {
		this.pjRepository = pjRepository;
	}

	private static void updateEntityFromDTO(final PessoaJuridicaDTO pjDTO, final PjuridicaEntity pjEntity) {
		pjEntity.setId(pjDTO.getId());
		pjEntity.setNome(pjDTO.getNome());
		pjEntity.setResponsavel(pjDTO.getResponsavel());
		pjEntity.setTelefone(pjDTO.getTelefone());
		pjEntity.setCelular(pjDTO.getCelular());
		pjEntity.setEndereco_id(pjDTO.getEndereco_id());
		pjEntity.setUsuario_id(pjDTO.getUsuario_id());
	
	
	}

	private static PjuridicaEntity toEntity(final PessoaJuridicaDTO pjDTO) {
		final long id = pjDTO.getId();	
		final String nome = pjDTO.getNome();
		final String responsavel = pjDTO.getResponsavel();
		final String cnpj = pjDTO.getCnpj();
		final String telefone = pjDTO.getTelefone();
		final String celular = pjDTO.getCelular();
		final long endereco_id = pjDTO.getEndereco_id();
		final long usuario_id =pjDTO.getUsuario_id();
		return new PjuridicaEntity(id, nome, responsavel, cnpj, telefone, celular,endereco_id,usuario_id);
	}

	private static PessoaJuridicaDTO toDTO(final PjuridicaEntity pjEntity) {
		final long id = pjEntity.getId();	
		final String nome = pjEntity.getNome();
		final String responsavel = pjEntity.getResponsavel();
		final String cnpj = pjEntity.getCnpj();
		final String telefone = pjEntity.getTelefone();
		final String celular = pjEntity.getCelular();
		final long endereco_id = pjEntity.getEndereco_id();
		final long usuario_id = pjEntity.getUsuario_id();
		return new PessoaJuridicaDTO(id, nome, responsavel, cnpj, telefone, celular, endereco_id, usuario_id);
	}

	/*private boolean isNotExistsProductByIdentifier(final Long id) {
		// TODO Auto-generated method stub
		return !this.pjRepository.existsById(id);
	}*/

	List<PessoaJuridicaDTO> getAllPj() {
		final List<PessoaJuridicaDTO> pjDTO = new ArrayList<>();
		this.pjRepository.findAll().forEach(pjEntity -> pjDTO.add(PjuridicaController.toDTO(pjEntity)));
		return pjDTO;
	}

	PessoaJuridicaDTO getPj(final Long id) {
		final Optional<PjuridicaEntity> optionalPj = this.pjRepository.findById(id);
		if (optionalPj.isPresent()) {
			return PjuridicaController.toDTO(optionalPj.get());
		}
		return PessoaJuridicaDTO.NULL_VALUE;
	}

	PessoaJuridicaDTO removePj(final Long id) {
		final Optional<PjuridicaEntity> optionalPj = this.pjRepository.findById(id);
		if (optionalPj.isPresent()) {
			final PjuridicaEntity pjEntity = optionalPj.get();
			this.pjRepository.delete(pjEntity);
			return PjuridicaController.toDTO(pjEntity);
		}
		return PessoaJuridicaDTO.NULL_VALUE;
	}

	Long insertPj(final PessoaJuridicaDTO pjDTO) {
		final PjuridicaEntity pjEntity = PjuridicaController.toEntity(pjDTO);
		this.pjRepository.save(pjEntity);
		return pjEntity.getId();
	}

	PessoaJuridicaDTO updatePj(final Long id, final PessoaJuridicaDTO pjDTO) {
		final Optional<PjuridicaEntity> optionalPj = this.pjRepository.findById(id);
		if (optionalPj.isPresent()) {
			final PjuridicaEntity pjEntity = optionalPj.get();
			final PessoaJuridicaDTO oldPj = PjuridicaController.toDTO(pjEntity);
			PjuridicaController.updateEntityFromDTO(pjDTO, pjEntity);
			this.pjRepository.save(pjEntity);
			return oldPj;
		}
		return PessoaJuridicaDTO.NULL_VALUE;
		
	}

}
