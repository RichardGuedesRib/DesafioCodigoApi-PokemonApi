package dio.project.pokemonapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.project.pokemonapi.models.entities.CapturedRequest;
import dio.project.pokemonapi.models.entities.PokemonCapturedModel;
import dio.project.pokemonapi.models.entities.PokemonModel;
import dio.project.pokemonapi.models.entities.TreinadorModel;
import dio.project.pokemonapi.services.PokemonCapturedService;
import dio.project.pokemonapi.services.PokemonService;
import dio.project.pokemonapi.services.TreinadorService;

@RestController
@RequestMapping(value = "/treinadores")
public class TreinadorController {

	@Autowired
	TreinadorService treinadorService;
	@Autowired
	PokemonService pokemonService;
	@Autowired
	PokemonCapturedService pokemonCapturedService;

	@GetMapping
	public ResponseEntity<?> findAllTreinador() {
		List<TreinadorModel> listTreinadores = treinadorService.findAll();
		return ResponseEntity.ok().body(listTreinadores);
	}

	@PostMapping
	public ResponseEntity<?> saveTreinador(@RequestBody TreinadorModel treinador) {
		treinadorService.saveTreinador(treinador);
		return ResponseEntity.ok().body(treinador);
	}

	@PostMapping(value = "/capturepokemon")
	public ResponseEntity<?> capturePokemon(@RequestBody CapturedRequest capturedRequest) {
		PokemonModel pokemon = pokemonService.findById(capturedRequest.getIdpokemon());
		TreinadorModel treinador = treinadorService.findById(capturedRequest.getIdtreinador());
		if (pokemon == null || treinador == null) {
			if (pokemon == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("Pokemon informado não existe no Banco de Dados");
			}
			if (treinador == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("Treinador informado não existe no Banco de Dados");
			}
		} else {
			PokemonCapturedModel pokemonCaptured = new PokemonCapturedModel(null, capturedRequest.getNomepokemon(),
					pokemon);
			pokemonCapturedService.savePokemonCaptured(pokemonCaptured);
			treinador.setPokemons(pokemonCaptured);
			treinadorService.saveTreinador(treinador);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(treinador);
		}
		return null;

	}

}
