package br.edu.infnet.projetodebloco.heroigen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.google.gson.GsonBuilder;

import br.edu.infnet.projetodebloco.heroigen.enums.HeroisEnum;
import br.edu.infnet.projetodebloco.heroigen.enums.IniciativaEnum;
import br.edu.infnet.projetodebloco.heroigen.enums.MonstrosEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ItemLog {
	
	@Id @GeneratedValue
	private Integer id;

	@NotNull
	@Min(value = 1, message="IdBatalha não pode ser negativo")
	private Integer id_batalha;
	
	@NotBlank(message = "Usuario não pode ser vazio")
	private String usuario;
	
	@NotNull(message = "Herói não pode ser vazio")
	private HeroisEnum heroi;

	@NotNull(message = "Monstro não pode ser vazio")
	private MonstrosEnum monstro;
	
	@NotNull(message = "Iniciativa não pode ser vazio")
	private IniciativaEnum iniciativa;
	
	@Min(value = 0, message="Dano não pode ser negativo")
	@Max(value = 18, message="Dano não pode ser maior que 18")
	@NotNull(message = "Dano não pode ser null")
	private Integer dano;
	
	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
