package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("                                  -=-=-=-=-=-=-=-=-=-=-=-=-=- Application is starting to run -=-=-=-=-=-=-=-=-=-=-=-=-=-");
		SpringApplication.run(ECommerceApplication.class, args);
		System.out.println();
		System.out.println("                                  -=-=-=-=-=-=-=-=-=-=-=-=-=- Application is working fine -=-=-=-=-=-=-=-=-=-=-=-=-=-");
	}

}
