package dio.project.pokemonapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dio.project.pokemonapi.models.entities.PokemonModel;

public interface PokemonRepository extends JpaRepository<PokemonModel, Integer> {

}
