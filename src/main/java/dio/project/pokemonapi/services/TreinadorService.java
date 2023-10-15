package dio.project.pokemonapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.project.pokemonapi.models.entities.TreinadorModel;
import dio.project.pokemonapi.repositories.TreinadorRepository;


@Service
public class TreinadorService {

	@Autowired
	TreinadorRepository treinadorRepository;

	public List<TreinadorModel> findAll() {
		List<TreinadorModel> listTreinadores = treinadorRepository.findAll();
		return listTreinadores;
	}

	public TreinadorModel findById(Integer id) {
		Optional<TreinadorModel> treinador = treinadorRepository.findById(id);
		return treinador.orElse(null);

	}
	
	public void saveTreinador(TreinadorModel treinador) {
		treinadorRepository.save(treinador);		
	}
	
	public void delteTreinadorById(Integer id) {
		treinadorRepository.deleteById(id);
	}

}
