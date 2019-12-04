package br.edu.sc.senai.loguinho.pessoajuridica;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;

import br.edu.sc.senai.loguinho.endereco.EnderecoEntity;
import br.edu.sc.senai.loguinho.usuario.UsuarioEntity;

@Entity
@Table(name = "PessoaJuridica")
public class PjuridicaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@NotEmpty
	@Column(length = 10)
	private String nome;
	@NotEmpty
	@Column(length = 10)
	private String responsavel;
	@NotEmpty
	@Column(length = 15)
	@CNPJ
	private String cnpj;
	@NotEmpty
	@Column(length = 15)
	private String telefone;
	@NotEmpty
	@Column(length = 15)
	private String celular;
	@Column(name="endereco_id",insertable = false,updatable = false,nullable = false)
	private long endereco_id;
	@OneToOne
	private EnderecoEntity endereco;
	@Column(name="usuario_id",insertable = false,updatable = false,nullable = false)
	private long usuario_id;
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
	
	public PjuridicaEntity(long id, @NotEmpty String nome, @NotEmpty String responsavel, @NotEmpty @CNPJ String cnpj,
			@NotEmpty String telefone, @NotEmpty String celular, long endereco_id, long usuario_id) {
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
	public long getEndereco_id() {
		return endereco_id;
	}
	public void setEndereco_id(long endereco_id) {
		this.endereco_id = endereco_id;
	}
	public long getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(long usuario_id) {
		this.usuario_id = usuario_id;
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
