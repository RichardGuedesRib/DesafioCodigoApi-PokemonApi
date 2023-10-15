package dio.project.pokemonapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dio.project.pokemonapi.models.entities.PokemonModel;
import dio.project.pokemonapi.services.PokemonAPI;
import dio.project.pokemonapi.services.PokemonService;

@RestController
@RequestMapping(value = "/pokemons")
public class PokemonController {

	@Autowired
	PokemonAPI pokemonapi;

	@Autowired
	PokemonService pokemonService;

	@GetMapping
	public ResponseEntity<?> findAll() throws Exception {
		List<PokemonModel> listPokemons = pokemonService.findAll();
		return ResponseEntity.ok().body(listPokemons);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<String> findById(@PathVariable Integer id) throws Exception {
		PokemonModel pokemon = pokemonService.findById(id);
		if (pokemon != null) {
			return ResponseEntity.ok().body(pokemon.toString());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Não existe pokemon registrado no BD com o Id informado, Faça o registro e tente novamente");
		}
	}

	@PostMapping(value = "/registerone")
	public ResponseEntity<?> registerOne(@RequestParam(value = "idPok", required = true) Integer id) throws Exception {

		PokemonModel pokemon = pokemonapi.findPokemonById(id);

		if (pokemon != null) {
			if (pokemonService.findById(id) == null) {
				pokemonService.registerOne(pokemon);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(pokemon);
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT)
						.body("Já existe pokemon com o id informado na base de dados.");
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado pokemon com o Id informado!");
		}

	}

	@PostMapping(value = "/registermany")
	public ResponseEntity<?> registerMany(@RequestParam(value = "idinicial", required = true) Integer idInicial,
			@RequestParam(value = "idfinal", required = true) Integer idFinal) throws Exception {
		List<PokemonModel> listPokemons = new ArrayList<>();

		listPokemons = pokemonapi.findPokemonIntervals(idInicial, idFinal);

		for (PokemonModel pokemon : listPokemons) {
			pokemonService.registerOne(pokemon);
		}

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(listPokemons);

	}

}
