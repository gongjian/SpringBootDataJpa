package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//启用定制的Repository
/*@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)*/
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}
}
