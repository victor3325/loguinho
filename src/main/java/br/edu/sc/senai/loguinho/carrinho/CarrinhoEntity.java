package br.edu.sc.senai.loguinho.carrinho;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import br.edu.sc.senai.loguinho.anuncio.AnuncioProdutoEntity;

@Entity
@Table(name = "Carrinho")
public class CarrinhoEntity implements Serializable{
	
	private static final long serialVersionUID = 4391164751402917205L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	@Column
	private double valor_unitario;
	@NotEmpty
	@Column
	private double valor_frete;
	@NotEmpty
	@Column
	private double total_pedido;
	@NotEmpty
	@Column
	private int quantidade;
	@Column(name="produto_id")
	private long produto_id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="produto_id",nullable = false,updatable = false,insertable = false)
	private AnuncioProdutoEntity produto;
	
	protected CarrinhoEntity() {
		
	}

	public CarrinhoEntity(long id, @NotEmpty double valor_unitario, @NotEmpty double valor_frete,
			@NotEmpty double total_pedido, @NotEmpty int quantidade, long produto_id, AnuncioProdutoEntity produto) {
		super();
		this.id = id;
		this.valor_unitario = valor_unitario;
		this.valor_frete = valor_frete;
		this.total_pedido = total_pedido;
		this.quantidade = quantidade;
		this.produto_id = produto_id;
		this.produto = produto;
	}

	public CarrinhoEntity(long id, @NotEmpty double valor_unitario, @NotEmpty double valor_frete,
			@NotEmpty double total_pedido, @NotEmpty int quantidade, long produto_id) {
		super();
		this.id = id;
		this.valor_unitario = valor_unitario;
		this.valor_frete = valor_frete;
		this.total_pedido = total_pedido;
		this.quantidade = quantidade;
		this.produto_id = produto_id;
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public long getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(long produto_id) {
		this.produto_id = produto_id;
	}

	public AnuncioProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(AnuncioProdutoEntity produto) {
		this.produto = produto;
	}
	
}


