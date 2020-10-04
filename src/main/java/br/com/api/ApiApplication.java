package br.com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	/**
	 * Construtor padrão
	 */
	public ApiApplication() {
		super();
	}

	/**
	 * Método main
	 * 
	 * @param args argumentos
	 */
	public static void main (String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
