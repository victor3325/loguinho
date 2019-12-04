package br.edu.sc.senai.loguinho.pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
public class PessoaController {
	private final	PessoaRepository pessoaRepository;
	
	public PessoaController(final PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	private static void updateEntityFromDTO(final PessoaDTO pDTO, final PessoaEntity pEntity) {
		pEntity.setId(pDTO.getId());
		pEntity.setNome(pDTO.getNome());
		pEntity.setSobrenome(pDTO.getSobrenome());
		pEntity.setNome_empresa(pDTO.getNome_empresa());
		pEntity.setCnpj(pDTO.getCnpj());
		pEntity.setTelefone(pDTO.getTelefone());
		pEntity.setCelular(pDTO.getCelular());
		pEntity.setResponsavel(pDTO.getResponsavel());
		pEntity.setResponsavel(pDTO.getResponsavel());
		pEntity.setPais(pDTO.getPais());
		pEntity.setEstado(pDTO.getEstado());
		pEntity.setCidade(pDTO.getCidade());
		pEntity.setBairro(pDTO.getBairro());
		pEntity.setRua(pDTO.getRua());
		pEntity.setCep(pDTO.getCep());
	}
	
	private static PessoaEntity toEntity(final PessoaDTO pDTO) {

		final long id = pDTO.getId();
		final String nome = pDTO.getNome();
		final String sobrenome = pDTO.getSobrenome();
		final String cpf = pDTO.getCpf();
		final String nome_empresa = pDTO.getNome_empresa();
		final String responsavel = pDTO.getResponsavel();
		final String cnpj = pDTO.getCnpj();
		final String telefone = pDTO.getTelefone();
		final String celular = pDTO.getCelular();
		final String pais = pDTO.getPais();
		final String estado = pDTO.getEstado();
		final String cidade = pDTO.getCidade();
		final String bairro = pDTO.getBairro();
		final String rua= pDTO.getRua();
		final String cep = pDTO.getCep();

		return new PessoaEntity(id, nome, sobrenome, cpf, nome_empresa, responsavel, cnpj, telefone, celular, pais, estado, cidade, bairro, rua, cep);
	}
	
	private static PessoaDTO toDTO(final PessoaEntity pEntity) {
		

		final long id = pEntity.getId();
		final String nome = pEntity.getNome();
		final String sobrenome = pEntity.getSobrenome();
		final String cpf = pEntity.getCpf();
		final String nome_empresa = pEntity.getNome_empresa();
		final String responsavel = pEntity.getResponsavel();
		final String cnpj = pEntity.getCnpj();
		final String telefone = pEntity.getTelefone();
		final String celular = pEntity.getCelular();
		final String pais = pEntity.getPais();
		final String estado = pEntity.getEstado();
		final String cidade = pEntity.getCidade();
		final String bairro = pEntity.getBairro();
		final String rua= pEntity.getRua();
		final String cep = pEntity.getCep();
		
		return new PessoaDTO(id, nome, sobrenome, cpf, nome_empresa, responsavel, cnpj, telefone, celular, pais, estado, cidade, bairro, rua, cep);
		
	}
	
	/*private boolean isNotExistsProductByIdentifier(final Long id) {
		// TODO Auto-generated method stub
		return !this.pessoaRepository.existsById(id);
	}*/
	
	List<PessoaDTO> getAllPessoa(){
		final List<PessoaDTO> pDTO = new ArrayList<>();
		this.pessoaRepository.findAll().forEach(pEntity -> pDTO.add(PessoaController.toDTO(pEntity)) );
		
		return pDTO;
	}
	
	PessoaDTO getPessoa(final Long id) {
		final Optional<PessoaEntity> optionalpessoa = this.pessoaRepository.findById(id);
		if (optionalpessoa.isPresent()) {
			return PessoaController.toDTO(optionalpessoa.get());
		}
		return PessoaDTO.NULL_VALUE;
	}
	PessoaDTO removePessoa(final Long id) {
		final Optional<PessoaEntity> optionalpessoa = this.pessoaRepository.findById(id);
		if (optionalpessoa.isPresent()) {
			final PessoaEntity pEntity = optionalpessoa.get();
			this.pessoaRepository.delete(pEntity);
			return PessoaController.toDTO(pEntity);
		}
			return PessoaDTO.NULL_VALUE;
	}
	Long insertPessoa(final PessoaDTO pessoaDTO) {
		final PessoaEntity pEntity = PessoaController.toEntity(pessoaDTO);
		this.pessoaRepository.save(pEntity);
		return pEntity.getId();
	}
	PessoaDTO updatePessoa(final Long id, final PessoaDTO pDTO){
		final Optional<PessoaEntity>optionalpessoa = this.pessoaRepository.findById(id);
		if(optionalpessoa.isPresent()) {
			final PessoaEntity pEntity = optionalpessoa.get();
			final PessoaDTO oldPessoa = PessoaController.toDTO(pEntity);
			PessoaController.updateEntityFromDTO(pDTO, pEntity);
			this.pessoaRepository.save(pEntity);
			return oldPessoa;
		}
		return PessoaDTO.NULL_VALUE;
	}
}
