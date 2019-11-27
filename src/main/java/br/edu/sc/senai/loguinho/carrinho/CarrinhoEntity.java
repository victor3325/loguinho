package br.edu.sc.senai.loguinho.carrinho;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.sc.senai.loguinho.anuncio.AnuncioProdutoEntity;

@Entity
@Table(name = "Carrinho")
public class CarrinhoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private double valor_unitario;
	@Column
	private double valor_frete;
	@Column
	private double total_pedido;
	@OneToOne
	private AnuncioProdutoEntity produto;
	
	protected CarrinhoEntity() {
		
	}
	
	public CarrinhoEntity(long id, double valor_unitario, double valor_frete, double total_pedido,
			AnuncioProdutoEntity produto) {
		super();
		this.id = id;
		this.valor_unitario = valor_unitario;
		this.valor_frete = valor_frete;
		this.total_pedido = total_pedido;
		this.produto = produto;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public double getValor_frete() {
		return valor_frete;
	}
	public void setValor_frete(double valor_frete) {
		this.valor_frete = valor_frete;
	}
	public double getTotal_pedido() {
		return total_pedido;
	}
	public void setTotal_pedido(double total_pedido) {
		this.total_pedido = total_pedido;
	}
	public AnuncioProdutoEntity getProduto() {
		return produto;
	}
	public void setProduto(AnuncioProdutoEntity produto) {
		this.produto = produto;
	}
	
	
}


