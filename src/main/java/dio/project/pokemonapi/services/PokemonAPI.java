package dio.project.pokemonapi.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import dio.project.pokemonapi.models.entities.PokemonModel;

@Service
public class PokemonAPI {

	public static String enderecoRequest = "https://pokeapi.co/api/v2/pokemon";

	public String findAllPokemons() throws Exception {
		String results = null;
		try {
			URL url = new URL(enderecoRequest);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			if (connection.getResponseCode() != 200) {
				throw new Exception("Erro ao conectar API: " + connection.getResponseCode());
			}

			BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder jsonString = new StringBuilder();

			String line;

			while ((line = response.readLine()) != null) {
				jsonString.append(line);
			}

			JSONObject json = new JSONObject(jsonString.toString());
			results = json.toString();
			System.out.println("Lendo o método. Cadastro: " + results);
			return results;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public PokemonModel findPokemonById(Integer id) throws Exception {
		try {
			String request = enderecoRequest + "/" + id;
			URL url = new URL(request);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			if (connection.getResponseCode() != 200) {
				throw new Exception("Erro ao conectar API: " + connection.getResponseCode());
			}

			BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			PokemonModel pokemon = instanciarPokemon(response, id);

			return pokemon;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public List<PokemonModel> findPokemonIntervals(Integer idInicio, Integer idFinal) throws Exception {

		List<PokemonModel> listPokemons = new ArrayList<>();

		for (int i = idInicio; i <= idFinal; i++) {
			Integer id = i;
			try {
				String request = enderecoRequest + "/" + id;
				URL url = new URL(request);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();

				if (connection.getResponseCode() != 200) {
					throw new Exception("Erro ao conectar API: " + connection.getResponseCode());
				}

				BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				PokemonModel pokemon = instanciarPokemon(response, id);

				listPokemons.add(pokemon);

			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

		return listPokemons;

	}

	private PokemonModel instanciarPokemon(BufferedReader response, Integer id) throws IOException {
		StringBuilder jsonString = new StringBuilder();

		String line;

		while ((line = response.readLine()) != null) {
			jsonString.append(line);
		}

		JSONObject json = new JSONObject(jsonString.toString());

		PokemonModel pokemon = new PokemonModel();
		pokemon.setEspecie(json.getString("name"));
		List<String> tipos = new ArrayList<>();

		JSONArray typesArray = json.getJSONArray("types");
		for (int i = 0; i < typesArray.length(); i++) {
			JSONObject typeObject = typesArray.getJSONObject(i);
			JSONObject type = typeObject.getJSONObject("type");
			tipos.add(type.getString("name"));
		}
		pokemon.setTipos(tipos);
		pokemon.setIdApi(id);
		pokemon.setPeso(json.getDouble("weight"));

		List<String> habilidades = new ArrayList<>();
		JSONArray abilitiesArray = json.getJSONArray("abilities");
		for (int i = 0; i < abilitiesArray.length(); i++) {
			JSONObject abilitiesObject = abilitiesArray.getJSONObject(i);
			JSONObject ability = abilitiesObject.getJSONObject("ability");
			habilidades.add(ability.getString("name"));
		}
		pokemon.setHabilidades(habilidades);

		return pokemon;
	}

}
