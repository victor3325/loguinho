package br.edu.sc.senai.loguinho.anuncio;

public class AnuncioProdutoDTO {
		
	public static final AnuncioProdutoDTO NULL_VALUE = new AnuncioProdutoDTO(Long.valueOf(0), "", Double.valueOf(0.0), Integer.valueOf(0),"", "", "", "");
	
		private final long id;
		private final String nome;
	    private final double preco_unit;
	    private final int quantidade;
	    private final String categoria;
	    private final String moeda;
	    private final String descricao;
	    private final String imagem_produto;

	    
		public AnuncioProdutoDTO(long id, String nome, double preco_unit, int quantidade, String categoria,
				String moeda, String descricao, String imagem_produto) {
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
		public static AnuncioProdutoDTO getNullValue() {
			return NULL_VALUE;
		}
		public long getId() {
			return id;
		}
		public String getNome() {
			return nome;
		}
		public double getPreco_unit() {
			return preco_unit;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public String getCategoria() {
			return categoria;
		}
		public String getMoeda() {
			return moeda;
		}
		
		public String getDescricao() {
			return descricao;
		}
		public String getImagem_produto() {
			return imagem_produto;
		}
		    
}
