package hu.pbes.blog.functionexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class FunctionExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(FunctionCatalog catalog) {
		return args -> {
			Function<String, String> uppercase = catalog.lookup("uppercase");
			System.out.println(uppercase.apply("hello world"));
		};
	}

	@Bean
	public Function<String, String> uppercase() {
		return value -> value.toUpperCase();
	}

}
