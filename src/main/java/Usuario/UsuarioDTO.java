package Usuario;

public class UsuarioDTO {
	
	
	public static final UsuarioDTO NULL_VALUE = new UsuarioDTO(Long.valueOf(0),"","","");
	private final long id;
	private final String login;
	private final String email;
	private final String senha;

	public UsuarioDTO(long id, String login, String email, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;
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

	public String getLogin() {
		return login;
	}


}
