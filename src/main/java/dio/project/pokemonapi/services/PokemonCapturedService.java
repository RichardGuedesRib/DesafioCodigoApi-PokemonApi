package dio.project.pokemonapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.project.pokemonapi.models.entities.PokemonCapturedModel;
import dio.project.pokemonapi.models.entities.TreinadorModel;
import dio.project.pokemonapi.repositories.PokemonCapturedModelRepository;


@Service
public class PokemonCapturedService {

	@Autowired
	PokemonCapturedModelRepository pokemonCapturedModelRepository;

	public List<PokemonCapturedModel> findAll() {
		List<PokemonCapturedModel> listPokemonCaptured = pokemonCapturedModelRepository.findAll();
		return listPokemonCaptured;
	}

	public PokemonCapturedModel findById(Integer id) {
		Optional<PokemonCapturedModel> pokemonCaptured = pokemonCapturedModelRepository.findById(id);
		return pokemonCaptured.orElse(null);

	}
	
	public void savePokemonCaptured(PokemonCapturedModel pokemonCaptured) {
		pokemonCapturedModelRepository.save(pokemonCaptured);		
	}
	
	public void deletePokemonCapturedById(Integer id) {
		pokemonCapturedModelRepository.deleteById(id);
	}

}
