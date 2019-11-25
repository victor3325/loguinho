package PessoaFisica;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
final class PfisicaController {

	private final PfisicaRepository pfisicaRepository;
	
	public PfisicaController(final PfisicaRepository pfisicaRepository) {
		this.pfisicaRepository = pfisicaRepository;
	}
	
	private static void updateEntityFromDTO(final PessoaFisicaDTO pfDTO, final PfisicaEntity pfEntity) {
		pfEntity.setId(pfDTO.getId());
		pfEntity.setNome(pfDTO.getNome());
		pfEntity.setSobrenome(pfDTO.getSobrenome());
		pfEntity.setTelefone(pfDTO.getTelefone());
		pfEntity.setPais(pfDTO.getPais());
		pfEntity.setEstado(pfDTO.getEstado());
		pfEntity.setCidade(pfDTO.getCidade());
		pfEntity.setBairro(pfDTO.getBairro());
		pfEntity.setRua(pfDTO.getRua());
		pfEntity.setCelular(pfDTO.getCelular());
		pfEntity.setCep(pfDTO.getCep());

	}
	
	private static PfisicaEntity toEntity(final PessoaFisicaDTO pfDTO) {

		final long id = pfDTO.getId();
		final String cpf = pfDTO.getCpf();
		final String nome = pfDTO.getNome();
		final String sobrenome = pfDTO.getSobrenome();
		final String telefone = pfDTO.getTelefone();
		final String celular = pfDTO.getCelular();
		final String pais = pfDTO.getPais();
		final String estado = pfDTO.getEstado();
		final String cidade = pfDTO.getCidade();
		final String bairro = pfDTO.getBairro();
		final String rua = pfDTO.getRua();
		final String cep = pfDTO.getCep();

		return new PfisicaEntity(id, cpf, nome, sobrenome, telefone, celular, pais,estado,cidade,bairro,rua,cep);
	}
	
	private static PessoaFisicaDTO toDTO(final PfisicaEntity pfEntity) {
		
		final long id = pfEntity.getId();
		final String cpf = pfEntity.getCpf();
		final String nome = pfEntity.getNome();
		final String sobrenome = pfEntity.getSobrenome();
		final String telefone = pfEntity.getTelefone();
		final String celular = pfEntity.getCelular();
		final String pais = pfEntity.getPais();
		final String estado = pfEntity.getEstado();
		final String cidade = pfEntity.getCidade();
		final String bairro = pfEntity.getBairro();
		final String rua = pfEntity.getRua();
		final String cep = pfEntity.getCep();
		
		return new PessoaFisicaDTO(id, nome, sobrenome, cpf, telefone, celular, pais, estado, cidade, bairro, rua, cep);
		
	}
	
	/*private boolean isNotExistsProductByIdentifier(final Long id) {
		// TODO Auto-generated method stub
		return !this.pfisicaRepository.existsById(id);
	}*/
	
	List<PessoaFisicaDTO> getAllPessoaFisica(){
		final List<PessoaFisicaDTO> pfDTO = new ArrayList<>();
		this.pfisicaRepository.findAll().forEach(pfEntity -> pfDTO.add(PfisicaController.toDTO(pfEntity)) );
		
		return pfDTO;
	}
	
	PessoaFisicaDTO getPessoaFisica(final Long id) {
		final Optional<PfisicaEntity> optionalPfisica = this.pfisicaRepository.findById(id);
		if (optionalPfisica.isPresent()) {
			return PfisicaController.toDTO(optionalPfisica.get());
		}
		return PessoaFisicaDTO.NULL_VALUE;
	}
	PessoaFisicaDTO removePessoaFisica(final Long id) {
		final Optional<PfisicaEntity> optionalPfisica = this.pfisicaRepository.findById(id);
		if (optionalPfisica.isPresent()) {
			final PfisicaEntity pfEntity = optionalPfisica.get();
			this.pfisicaRepository.delete(pfEntity);
			return PfisicaController.toDTO(pfEntity);
		}
			return PessoaFisicaDTO.NULL_VALUE;
	}
	Long insertPessoaFisica(final PessoaFisicaDTO pFisicaDTO) {
		final PfisicaEntity pfEntity = PfisicaController.toEntity(pFisicaDTO);
		this.pfisicaRepository.save(pfEntity);
		return pfEntity.getId();
	}
	PessoaFisicaDTO updatePessoaFisica(final Long id, final PessoaFisicaDTO pfDTO){
		final Optional<PfisicaEntity>optionalPfisica = this.pfisicaRepository.findById(id);
		if(optionalPfisica.isPresent()) {
			final PfisicaEntity pfEntity = optionalPfisica.get();
			final PessoaFisicaDTO oldPessoaFisica = PfisicaController.toDTO(pfEntity);
			PfisicaController.updateEntityFromDTO(pfDTO, pfEntity);
			this.pfisicaRepository.save(pfEntity);
			return oldPessoaFisica;
		}
		return PessoaFisicaDTO.NULL_VALUE;
	}
}
