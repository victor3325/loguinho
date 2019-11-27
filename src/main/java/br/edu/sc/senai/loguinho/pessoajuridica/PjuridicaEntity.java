package br.edu.sc.senai.loguinho.pessoajuridica;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.sc.senai.loguinho.endereco.EnderecoEntity;
import br.edu.sc.senai.loguinho.usuario.UsuarioEntity;

@Entity
@Table(name = "PessoaJuridica")
public class PjuridicaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@Column
	private String nome;
	@Column
	private String responsavel;
	@Column
	private String cnpj;
	@Column
	private String telefone;
	@Column
	private String celular;
	@OneToOne
	private EnderecoEntity endereco;
	@OneToOne
	private UsuarioEntity usuario;
	
	protected PjuridicaEntity() {
		
	}
	public PjuridicaEntity(long id, String nome, String responsavel, String cnpj, String telefone, String celular,
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
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
	
	
}
