package com.devsuperior.hrconfigserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class HrConfigServerApplication implements CommandLineRunner{
	
	@Value("${spring.cloud.config.server.git.username}")
	private String valor;
	
	private static Logger logger = LoggerFactory.getLogger(HrConfigServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.error("................................................................");
		logger.error("FALTA CONFIGURAR USUÁRIO E SENHA DO GITHUB NO ARQUIVO PROPERIES");
		logger.error("................................................................");
		
	}

}
