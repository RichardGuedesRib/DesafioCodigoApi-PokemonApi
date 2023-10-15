package dio.project.pokemonapi.models.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_treinador")
public class TreinadorModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private Integer idade;
	private String cidade;
	@OneToMany
	List<PokemonCapturedModel> pokemons;
	
	public TreinadorModel() {
		super();
	}

	public TreinadorModel(Integer id, String nome, Integer idade, String cidade, List<PokemonCapturedModel> pokemons) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.cidade = cidade;
		this.pokemons = pokemons;
	}

	public TreinadorModel(Integer id, String nome, Integer idade, String cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.cidade = cidade;
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<PokemonCapturedModel> getPokemons() {
		return pokemons;
	}

	public void setPokemons(PokemonCapturedModel pokemon) {
		this.pokemons.add(pokemon);
	}

	@Override
	public String toString() {
		return "TreinadorModel [id=" + id + ", nome=" + nome + ", idade=" + idade + ", cidade=" + cidade + ", pokemons="
				+ pokemons + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
