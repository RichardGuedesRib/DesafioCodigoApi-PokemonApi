package dio.project.pokemonapi.models.entities;

public class CapturedRequest {
	
	private Integer idpokemon;
	private Integer idtreinador;
	private String nomepokemon;
	
	public CapturedRequest(Integer idpokemon, Integer idtreinador, String nomepokemon) {
		super();
		this.idpokemon = idpokemon;
		this.idtreinador = idtreinador;
		this.nomepokemon = nomepokemon;
	}

	public Integer getIdpokemon() {
		return idpokemon;
	}

	public void setIdpokemon(Integer idpokemon) {
		this.idpokemon = idpokemon;
	}

	public Integer getIdtreinador() {
		return idtreinador;
	}

	public void setIdtreinador(Integer idtreinador) {
		this.idtreinador = idtreinador;
	}

	public String getNomepokemon() {
		return nomepokemon;
	}

	public void setNomepokemon(String nomepokemon) {
		this.nomepokemon = nomepokemon;
	}
	
	
	
	

}
