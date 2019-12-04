package br.edu.sc.senai.loguinho.pessoafisica;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import br.edu.sc.senai.loguinho.endereco.EnderecoEntity;
import br.edu.sc.senai.loguinho.usuario.UsuarioEntity;

@Entity
@Table(name = "PessoaFisica")
public class PfisicaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	@NotEmpty
	@Column(length = 10)
	private String nome;
	@NotEmpty
	@Column(length = 12)
	private String sobrenome;
	@NotEmpty
	@Column(length = 15)
	private String cpf;
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
	
	protected PfisicaEntity() {
		
	}
	
	
	
	public PfisicaEntity(long id, @NotEmpty String nome, @NotEmpty String sobrenome, @NotEmpty String cpf,
			@NotEmpty String telefone, @NotEmpty String celular, long endereco_id, EnderecoEntity endereco,
			long usuario_id, UsuarioEntity usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.endereco_id = endereco_id;
		this.endereco = endereco;
		this.usuario_id = usuario_id;
		this.usuario = usuario;
	}



	public PfisicaEntity(long id, @NotEmpty String nome, @NotEmpty String sobrenome, @NotEmpty String cpf,
			@NotEmpty String telefone, @NotEmpty String celular, long endereco_id, long usuario_id) {
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
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public long getEndereco_id() {
		return endereco_id;
	}
	public void setEndereco_id(long endereco_id) {
		this.endereco_id = endereco_id;
	}
	public EnderecoEntity getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}
	public long getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(long usuario_id) {
		this.usuario_id = usuario_id;
	}
	public UsuarioEntity getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	
	
}
