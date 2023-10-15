package dio.project.pokemonapi.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pokemonsCaptured")
public class PokemonCapturedModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	@OneToOne
	private PokemonModel pokemon;
	
	public PokemonCapturedModel() {
		super();
	}

	public PokemonCapturedModel(Integer id, String nome, PokemonModel pokemon) {
		super();
		this.id = id;
		this.nome = nome;
		this.pokemon = pokemon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PokemonModel getPokemon() {
		return pokemon;
	}

	public void setPokemon(PokemonModel pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public String toString() {
		return "PokemonCaptured [id=" + id + ", nome=" + nome + ", pokemon=" + pokemon + "]";
	}
	
	
	
	

}
