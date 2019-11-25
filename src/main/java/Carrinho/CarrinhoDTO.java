package Carrinho;

public class CarrinhoDTO {
	public static final CarrinhoDTO NULL_VALUE = new CarrinhoDTO(Long.valueOf(0),Double.valueOf(0.0),Double.valueOf(0.0),Double.valueOf(0.0));
	
	private long id;
	private double valor_unitario;
	private double valor_frete;
	private double total_pedido;
	
	public CarrinhoDTO(long id, double valor_unitario, double valor_frete, double total_pedido) {
		this.id = id;
		this.valor_unitario = valor_unitario;
		this.valor_frete = valor_frete;
		this.total_pedido = total_pedido;
	}

	public long getId() {
		return id;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}

	public double getvalor_Frete() {
		return valor_frete;
	}

	public double getTotal_pedido() {
		return total_pedido;
	}
	
	

}
