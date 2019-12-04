package br.edu.sc.senai.loguinho.pessoa;

public class PessoaDTO {
	
	public static final PessoaDTO NULL_VALUE = new PessoaDTO(Long.valueOf(0), "", "", "", "", "", "", "", "", "","", "", "", "", "");
	private final long id;	
	private final String nome;
	private final String sobrenome;
	private final String cpf;
	private final String nome_empresa;
	private final String responsavel;
	private final String cnpj;
	private final String telefone;
	private final String celular;
	private final String pais;
	private final String estado;
	private final String cidade;
	private final String bairro;
	private final String rua;
	private final String cep;
	public PessoaDTO(long id, String nome, String sobrenome, String cpf, String nome_empresa, String responsavel,
			String cnpj, String telefone, String celular, String pais, String estado, String cidade, String bairro,
			String rua, String cep) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.nome_empresa = nome_empresa;
		this.responsavel = responsavel;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.celular = celular;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.cep = cep;
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
	public String getNome_empresa() {
		return nome_empresa;
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
