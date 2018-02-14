package bbsmt.bloqq.bloqq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"bbsmt.bloqq.bloqq.controller"})
public class BloqqApplication {
	public static void main(String[] args) {
		SpringApplication.run(BloqqApplication.class, args);
	}
}
