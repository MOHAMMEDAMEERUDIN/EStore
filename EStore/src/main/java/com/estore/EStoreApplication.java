package com.estore;

import com.estore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EStoreApplication implements CommandLineRunner {
	@Autowired
	ProductService productService;
	public static void main(String[] args) {
		SpringApplication.run(EStoreApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		productService.saveProducts();
	}
}
