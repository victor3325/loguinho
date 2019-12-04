package br.edu.sc.senai.loguinho.pessoajuridica;



public class PessoaJuridicaDTO {
	public static final PessoaJuridicaDTO NULL_VALUE = new PessoaJuridicaDTO(Long.valueOf(0), "", "", "", "", "", Long.valueOf(0),Long.valueOf(0));
	
	private final long id;	
	private final String nome;
	private final String responsavel;
	private final String cnpj;
	private final String telefone;
	private final String celular;
	private final long endereco_id;
	private final long usuario_id;
	public PessoaJuridicaDTO(long id, String nome, String responsavel, String cnpj, String telefone, String celular,
			long endereco_id, long usuario_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.responsavel = responsavel;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.celular = celular;
		this.endereco_id = endereco_id;
		this.usuario_id = usuario_id;
	}
	public static PessoaJuridicaDTO getNullValue() {
		return NULL_VALUE;
	}
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public String getCnpj() {
		return cnpj;
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