package dio.project.pokemonapi.models.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pokemons")
public class PokemonModel {
	
	@Id
	private Integer idApi;
	private String especie;
	private Double peso;
	private List<String> tipos;
	private List<String> habilidades;
	
	public PokemonModel(Integer idApi, String especie, Double peso, List<String> tipos,
			List<String> habilidades) {
		super();
		
		this.idApi = idApi;
		this.especie = especie;
		this.peso = peso;
		this.tipos = tipos;
		this.habilidades = habilidades;
	}
	public PokemonModel() {
		super();
	}
	public Integer getIdApi() {
		return idApi;
	}
	public void setIdApi(Integer idApi) {
		this.idApi = idApi;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public List<String> getTipos() {
		return tipos;
	}
	public void setTipos(List<String> tipos) {
		this.tipos = tipos;
	}
	public List<String> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<String> habilidades) {
		this.habilidades = habilidades;
	}
	@Override
	public String toString() {
		return "PokemonModel [idApi=" + idApi + ", especie=" + especie + ", peso=" + peso + ", tipos=" + tipos
				+ ", habilidades=" + habilidades + "]";
	}
	
	
	

}
