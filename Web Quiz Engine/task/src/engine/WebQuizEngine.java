package engine;

import engine.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebQuizEngine {

    public static void main(String[] args) {
        SpringApplication.run(WebQuizEngine.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        System.out.println("SpringsecurityjpaApplication.demo");
        return (args) -> {
            // save a few users
            repository.save(new User("admin", "adminpass", true, "ROLE_USER,ROLE_ADMIN"));
            repository.save(new User("user", "pass", true, "ROLE_USER"));
            repository.findAll()
                    .forEach(System.out::println);
        };
    }

}
