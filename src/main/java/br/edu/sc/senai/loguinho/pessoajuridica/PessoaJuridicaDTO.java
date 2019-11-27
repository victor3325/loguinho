package br.edu.sc.senai.loguinho.pessoajuridica;

import br.edu.sc.senai.loguinho.endereco.EnderecoEntity;
import br.edu.sc.senai.loguinho.usuario.UsuarioEntity;

public class PessoaJuridicaDTO {
	public static final PessoaJuridicaDTO NULL_VALUE = new PessoaJuridicaDTO(Long.valueOf(0), "", "", "", "", "", null,null);
	
	private final long id;	
	private final String nome;
	private final String responsavel;
	private final String cnpj;
	private final String telefone;
	private final String celular;
	private final EnderecoEntity endereco;
	private final UsuarioEntity usuario;
	public PessoaJuridicaDTO(long id, String nome, String responsavel, String cnpj, String telefone, String celular,
			EnderecoEntity endereco, UsuarioEntity usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.responsavel = responsavel;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.celular = celular;
		this.endereco = endereco;
		this.usuario = usuario;
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
	public EnderecoEntity getEndereco() {
		return endereco;
	}
	public UsuarioEntity getUsuario() {
		return usuario;
	}
	
	
}