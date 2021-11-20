package be.henallux.spring.sportProjects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SportProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportProductsApplication.class, args);
		System.out.println("App running on http://127.0.0.1:8082/sportProducts");
	}

}
