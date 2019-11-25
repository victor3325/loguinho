package PessoaFisica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PessoaFisica")
final class PfisicaEntity implements Serializable {
	private static final long serialVersionUID = 4391164751402917205L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	@Column
	private String nome;
	@Column
	private String sobrenome;
	@Column
	private String cpf;
	@Column
	private String telefone;
	@Column
	private String celular;
	@Column
	private String pais;
	@Column
	private String estado;
	@Column
	private String cidade;
	@Column
	private String bairro;
	@Column
	private String rua;
	@Column
	private String cep;
	
	
	public PfisicaEntity(long id, String nome, String sobrenome, String cpf, String telefone, String celular,
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
	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "PfisicaEntity [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf
				+ ", telefone=" + telefone + ", celular=" + celular + ", pais=" + pais + ", estado=" + estado
				+ ", cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua + ", cep=" + cep + "]";
	}

	

}
