package dio.project.pokemonapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "dio.project.pokemonapi.repositories")
public class PokemonapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonapiApplication.class, args);
	}

}
