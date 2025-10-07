package BenchJava2025.bench;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BenchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenchApplication.class, args);
	}

}
