package backend.projects.securityjpa;

import backend.projects.securityjpa.resources.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class SecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityJpaApplication.class, args);
	}

}
