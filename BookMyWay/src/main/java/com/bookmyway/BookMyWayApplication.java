package com.bookmyway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyWayApplication {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("                                  -=-=-=-=-=-=-=-=-=-=-=-=-=- Application is starting -=-=-=-=-=-=-=-=-=-=-=-=-=-");
		SpringApplication.run(BookMyWayApplication.class, args);
		System.out.println();
		System.out.println("                                  -=-=-=-=-=-=-=-=-=-=-=-=-=- Application is working fine -=-=-=-=-=-=-=-=-=-=-=-=-=-");
	}

}
