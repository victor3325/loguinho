package Endereco;

public class EnderecoDTO {
	
	public static final EnderecoDTO NULL_VALUE = new EnderecoDTO(Long.valueOf(0), "", "", "", "", "", "");
	
	private final long id;
	private final String pais;
	private final String estado;
	private final String cidade;
	private final String bairro;
	private final String rua;
	private final String cep;
		
	public EnderecoDTO(long id, String pais, String estado, String cidade, String bairro, String rua, String cep) {
		super();
		this.id = id;
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
	
	
}
