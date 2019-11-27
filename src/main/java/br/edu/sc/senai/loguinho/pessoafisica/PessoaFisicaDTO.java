package br.edu.sc.senai.loguinho.pessoafisica;

import br.edu.sc.senai.loguinho.endereco.EnderecoEntity;
import br.edu.sc.senai.loguinho.usuario.UsuarioEntity;

public class PessoaFisicaDTO {
	
	public static final PessoaFisicaDTO NULL_VALUE = new PessoaFisicaDTO(Long.valueOf(0), "", "", "", "", "",null,null);
	
	private final long id;	
	private final String nome;
	private final String sobrenome;
	private final String cpf;
	private final String telefone;
	private final String celular;
	private EnderecoEntity endereco;
	private UsuarioEntity usuario;
	public PessoaFisicaDTO(long id, String nome, String sobrenome, String cpf, String telefone, String celular,
			EnderecoEntity endereco, UsuarioEntity usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.endereco = endereco;
		this.usuario = usuario;
	}
	public EnderecoEntity getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}
	public UsuarioEntity getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
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
	
}
