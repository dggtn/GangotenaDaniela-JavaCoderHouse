package com.coderhouse.java;

import com.coderhouse.java.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FacturacionApplication {



	public static void main(String[] args) {
		SpringApplication.run(FacturacionApplication.class, args);
	}

}
