package quincaillerieuserservice.quincaillerieuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class QuincaillerieUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuincaillerieUserServiceApplication.class, args);
	}

}
