package PessoaFisica;

public class PessoaFisicaDTO {
	
	public static final PessoaFisicaDTO NULL_VALUE = new PessoaFisicaDTO(Long.valueOf(0), "", "", "", "", "", "", "","", "", "", "");
	
	private final long id;	
	private final String nome;
	private final String sobrenome;
	private final String cpf;
	private final String telefone;
	private final String celular;
	private final String pais;
	private final String estado;
	private final String cidade;
	private final String bairro;
	private final String rua;
	private final String cep;
	
	public PessoaFisicaDTO(long id, String nome, String sobrenome, String cpf, String telefone, String celular,
			String pais, String estado, String cidade, String bairro, String rua, String cep) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.cep = cep;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCelular() {
		return celular;
	}

	public String getPais() {
		return pais;
	}

	public String getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public String getRua() {
		return rua;
	}

	public String getCep() {
		return cep;
	}
		 
}
