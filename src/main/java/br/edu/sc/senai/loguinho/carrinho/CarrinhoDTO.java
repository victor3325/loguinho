package br.edu.sc.senai.loguinho.carrinho;

import br.edu.sc.senai.loguinho.anuncio.AnuncioProdutoEntity;

public class CarrinhoDTO {
	public static final CarrinhoDTO NULL_VALUE = new CarrinhoDTO(Long.valueOf(0), Double.valueOf(0.0),
			Double.valueOf(0.0), Double.valueOf(0.0), Integer.valueOf(0) ,null);

	private final long id;
	private final double valor_unitario;
	private final double valor_frete;
	private final double total_pedido;
	private final int quantidade;
	private final AnuncioProdutoEntity produto;

	
	public CarrinhoDTO(long id, double valor_unitario, double valor_frete, double total_pedido, int quantidade,
			AnuncioProdutoEntity produto) {
		super();
		this.id = id;
		this.valor_unitario = valor_unitario;
		this.valor_frete = valor_frete;
		this.total_pedido = total_pedido;
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public static CarrinhoDTO getNullValue() {
		return NULL_VALUE;
	}

	public long getId() {
		return id;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}

	public double getValor_frete() {
		return valor_frete;
	}

	public double getTotal_pedido() {
		return total_pedido;
	}

	public AnuncioProdutoEntity getProduto() {
		return produto;
	}

}
