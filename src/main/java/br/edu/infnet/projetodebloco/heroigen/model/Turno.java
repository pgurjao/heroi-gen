package br.edu.infnet.projetodebloco.heroigen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.GsonBuilder;

import br.edu.infnet.projetodebloco.heroigen.enums.AtacanteEnum;
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
//@Table(name = "turno")
public class Turno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_generator")
	@SequenceGenerator(name="turno_generator", sequenceName = "turno_seq", allocationSize=50)
	private Integer id;

	@NotNull
	@Min(value = 1, message="IdBatalha não pode ser negativo")
//	@Column(name = "batalha_id")
	@Transient
	private Integer batalhaId;
	
	@NotBlank(message = "Usuario não pode ser vazio")
	private String usuario;
	
	@NotNull(message = "Herói não pode ser vazio")
	private String heroi;

	@NotNull(message = "Monstro não pode ser vazio")
	private String monstro;
	
	@NotNull(message = "Atacante não pode ser vazio")
	@Enumerated
	private AtacanteEnum atacante;
	
	@Min(value = 0, message="Dano não pode ser negativo")
	@Max(value = 18, message="Dano não pode ser maior que 18")
	@NotNull(message = "Dano não pode ser null")
	private Integer dano;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "batalha_id")
	private ItemRanking ranking;
	
	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
