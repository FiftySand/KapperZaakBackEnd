package logic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import restapi.AccountController;
import restapi.KapperController;


@SpringBootApplication
@EnableJpaRepositories("repository")
@Import({AccountController.class, KapperController.class})
public class SpringServer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder
                                                         application) {
        return application.sources(SpringServer.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringServer.class, args);
    }
}
