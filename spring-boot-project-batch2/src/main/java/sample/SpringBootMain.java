package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMain {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args);
		System.out.println("sample spring boot application");
		System.out.println("welcome to boot application");
	}
}
