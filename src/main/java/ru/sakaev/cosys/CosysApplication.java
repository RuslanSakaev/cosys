package ru.sakaev.cosys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.config.server.ConfigServerApplication;
import ru.sakaev.webclient.WebClientApplication;
import ru.sakaev.apiGateway.ApiGatewayApplication;
import ru.sakaev.backend.BackendApplication;
import ru.sakaev.eurekaServer.EurekaServerApplication;

@SpringBootApplication
public class CosysApplication {

	public static void main(String[] args) {
		// Запуск всех подмодулей
		runConfigServer();
		runEurekaServer();
		runApiGateway();
		runBackend();
		runWebClient();
	}

	// Методы для запуска подмодулей

	private static void runConfigServer() {
		SpringApplication.run(ConfigServerApplication.class, new String[]{});
	}

	private static void runEurekaServer() {
		SpringApplication.run(EurekaServerApplication.class, new String[]{});
	}

	private static void runApiGateway() {
		SpringApplication.run(ApiGatewayApplication.class, new String[]{});
	}

	private static void runBackend() {
		SpringApplication.run(BackendApplication.class, new String[]{});
	}

	private static void runWebClient() {
		SpringApplication.run(WebClientApplication.class, new String[]{});
	}
}
