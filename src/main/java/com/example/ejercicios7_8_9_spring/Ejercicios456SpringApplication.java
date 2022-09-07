package com.example.ejercicios7_8_9_spring;

import com.example.ejercicios7_8_9_spring.entities.Laptop;
import com.example.ejercicios7_8_9_spring.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicios456SpringApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicios456SpringApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null,"Asus","VivoBook",756.30,true);
		Laptop laptop2 = new Laptop(null,"HP","EliteBook",522.99,false);
		Laptop laptop3 = new Laptop(null,"Dell","XPS",649.00,true);

		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);

		System.out.println(repository.findAll().size());
	}

}
