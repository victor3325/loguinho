package br.edu.sc.senai.loguinho.anuncio;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.sc.senai.loguinho.pessoa.PessoaDTO;
import br.edu.sc.senai.loguinho.pessoa.PessoaEntity;

@Entity
@Table(name = "Anuncio")
public class AnuncioProdutoEntity implements Serializable{
	
	private static final long serialVersionUID = 4391164751402917205L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String nome;
	@Column
    private double preco_unit;
	@Column
    private int quantidade;
	@Column
    private String categoria;
	@Column
    private String moeda;
	@Column
    private String descricao;
	@Column
    private String imagem_produto;
			
	protected AnuncioProdutoEntity(){
		
	}
	public AnuncioProdutoEntity(long id, String nome, double preco_unit, int quantidade, String categoria, String moeda,
			 String descricao, String imagem_produto) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco_unit = preco_unit;
		this.quantidade = quantidade;
		this.categoria = categoria;
		this.moeda = moeda;
		
		this.descricao = descricao;
		this.imagem_produto = imagem_produto;
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
	public double getPreco_unit() {
		return preco_unit;
	}
	public void setPreco_unit(double preco_unit) {
		this.preco_unit = preco_unit;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getMoeda() {
		return moeda;
	}
	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImagem_produto() {
		return imagem_produto;
	}
	public void setImagem_produto(String imagem_produto) {
		this.imagem_produto = imagem_produto;
	}
	
	
}
