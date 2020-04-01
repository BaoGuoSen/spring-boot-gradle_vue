package mybatis.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration  
@SpringBootApplication 
@EnableTransactionManagement
public class Application {
	public static void main(String[] args) {  
        SpringApplication.run(Application.class, args);  
    } 
}
