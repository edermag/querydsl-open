package br.com.yaw.querydsl.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Entrypoint do Spring.
 * 
 * @author <a href="mailto:eder@yaw.com.br">Eder Magalhães</a>
 */
@SpringBootApplication
@ComponentScan(basePackages="br.com.yaw.querydsl")
@EntityScan(basePackages="br.com.yaw.querydsl.model")
@EnableJpaRepositories(basePackages="br.com.yaw.querydsl.persistence")
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
