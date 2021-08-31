package pl.filipwlodarczyk.Blog.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.filipwlodarczyk.Blog.engine.services.UserService;

@SpringBootApplication
public class BlogEngineV1Application {

	public static void main(String[] args) {

		SpringApplication.run(BlogEngineV1Application.class, args);

	}

}
