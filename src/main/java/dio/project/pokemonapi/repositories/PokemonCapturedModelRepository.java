package dio.project.pokemonapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dio.project.pokemonapi.models.entities.PokemonCapturedModel;

public interface PokemonCapturedModelRepository extends JpaRepository<PokemonCapturedModel, Integer> {

}
