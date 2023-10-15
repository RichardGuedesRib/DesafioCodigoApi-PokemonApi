package dio.project.pokemonapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dio.project.pokemonapi.models.entities.TreinadorModel;

public interface TreinadorRepository extends JpaRepository<TreinadorModel, Integer> {

}
