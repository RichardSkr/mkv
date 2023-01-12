package mkv.com.mkv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class MkvServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MkvServicesApplication.class, args);
	}

}
