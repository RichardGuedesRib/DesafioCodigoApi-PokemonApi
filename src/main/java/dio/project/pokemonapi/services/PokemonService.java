package dio.project.pokemonapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.project.pokemonapi.models.entities.PokemonModel;
import dio.project.pokemonapi.repositories.PokemonRepository;

@Service
public class PokemonService {
	
	@Autowired
	PokemonRepository pokemonRepository;
	
	public void registerOne(PokemonModel pokemon) {
		pokemonRepository.save(pokemon);
		System.out.println("Salvo no Banco de Dados");
		System.out.println(pokemon);
	}
	
	public PokemonModel findById(Integer id) {
		Optional<PokemonModel> pokemon = pokemonRepository.findById(id);
		return pokemon.orElse(null);
	}
	
	public List<PokemonModel> findAll(){
		List<PokemonModel> pokemons = pokemonRepository.findAll();
		return pokemons;
	}
	

}
