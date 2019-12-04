package br.edu.sc.senai.loguinho.usuario;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "Usuario")
public class UsuarioEntity implements Serializable{
	
	private static final long serialVersionUID = 4391164751402917205L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String login;
	@Email
	private String email;
	@Column
	private String senha;
	
	protected UsuarioEntity() {
		
	}

	public UsuarioEntity(long id, String login, String email, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;
	}

	
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}