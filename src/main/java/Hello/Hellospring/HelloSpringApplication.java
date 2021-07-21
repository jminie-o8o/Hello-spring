package Hello.Hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {

		//tomcat 이라는 웹서버를 내장하고 있다. 스프링부트가 이것을 자체적으로 띄우는 것이다.
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
