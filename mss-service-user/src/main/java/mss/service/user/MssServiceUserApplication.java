package mss.service.user;

import mss.global.handler.EnableGlobalDispose;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableGlobalDispose
public class MssServiceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MssServiceUserApplication.class, args);
	}

}
