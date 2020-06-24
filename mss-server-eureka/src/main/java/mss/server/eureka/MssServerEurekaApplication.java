package mss.server.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MssServerEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MssServerEurekaApplication.class, args);
	}

}
