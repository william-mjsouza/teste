package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.entity.Marca;
import app.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	public String save(Carro carro) {
		
		this.carroRepository.save(carro);
		
		return "Carro salvo com sucesso!";
	}
	
	public String update(Carro carro, Long id) {
		
		// Tem que setar o id pro método sber que o carro tá sendo atualizado,não criado
		carro.setId(id);
		this.carroRepository.save(carro);
		
		return "Carro atualizado com sucesso!";
	}
	
	public String delete(Long id) {
		
		this.carroRepository.deleteById(id);
		
		return "CArro deletado com sucesso!";
		
	}
	
	public List<Carro> findAll() {
		
		List<Carro> lista = this.carroRepository.findAll();
		
		return lista;
		
	}
	
	public Carro findById(Long id) {
		
		Carro carro = this.carroRepository.findById(id).get();
		
		return carro;
	}
	
	public List<Carro> findByNome(String nome) {
		
		List<Carro> carros = this.carroRepository.findByNome(nome);
		return carros;
	}
	
	public List<Carro> findByMarca(Long idMarca) {
		
		// Tem que setar o id da marca
		Marca marca = new Marca();
		marca.setId(idMarca);
		List<Carro> carros = this.carroRepository.findByMarca(marca);
		return carros;
	}
	
	public List<Carro> findAcimaAno(int ano) {
		
		List<Carro> carros = this.carroRepository.findAcimaAno(ano);
		return carros;
	}
	
}
