package io.github.reis.mscartoes;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
@Slf4j
public class MscartoesApplication {

	public static void main(String[] args) {
		log.info("Informação: {}" , "teste Info");
		log.error("Erro: {}" , "teste Erro");
		log.warn("Aviso: {}" , "teste Aviso");
		SpringApplication.run(MscartoesApplication.class, args);
	}

}
