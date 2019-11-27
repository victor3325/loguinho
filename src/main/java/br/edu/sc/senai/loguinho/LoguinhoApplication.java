package br.edu.sc.senai.loguinho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan(basePackages = {"Anuncio","Carrinho","Endereco","PessoaFisica","PessoaJuridica","Usuario"})
@SpringBootApplication
public class LoguinhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoguinhoApplication.class, args);
	}

}
