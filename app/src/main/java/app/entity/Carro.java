package app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY                                                                                        )
	private Long id;
	private String nome;
	private int ano;
	
	// cascade = CascadeType.ALL -> Quando atualizar carro, atualiza a marca junto também
	@ManyToOne(cascade = CascadeType.ALL)
	private Marca marca;
	
	// @JoinTable(name = "carro_proprietario") -> A tabela da relação que resolve o N:N vai se chamar carro_proprietario
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "carro_proprietario")
	private List<Proprietario> proprietarios;
	
}
