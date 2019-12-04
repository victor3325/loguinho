package br.edu.sc.senai.loguinho.pessoafisica;


public class PessoaFisicaDTO {
	
	public static final PessoaFisicaDTO NULL_VALUE = new PessoaFisicaDTO(Long.valueOf(0), "", "", "", "", "",Long.valueOf(0),Long.valueOf(0));
	
	private final long id;	
	private final String nome;
	private final String sobrenome;
	private final String cpf;
	private final String telefone;
	private final String celular;
	private final long endereco_id;
	private final long usuario_id;
	public PessoaFisicaDTO(long id, String nome, String sobrenome, String cpf, String telefone, String celular,
			long endereco_id, long usuario_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.endereco_id = endereco_id;
		this.usuario_id = usuario_id;
	}
	public static PessoaFisicaDTO getNullValue() {
		return NULL_VALUE;
	}
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getCelular() {
		return celular;
	}
	public long getEndereco_id() {
		return endereco_id;
	}
	public long getUsuario_id() {
		return usuario_id;
	}
	
}
