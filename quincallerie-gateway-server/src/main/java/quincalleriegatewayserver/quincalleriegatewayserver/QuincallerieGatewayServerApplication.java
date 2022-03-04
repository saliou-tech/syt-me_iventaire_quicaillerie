package quincalleriegatewayserver.quincalleriegatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class QuincallerieGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuincallerieGatewayServerApplication.class, args);
	}

}
