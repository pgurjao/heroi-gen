package br.edu.infnet.projetodebloco.heroigen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.google.gson.GsonBuilder;

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
public class Heroi {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "heroi_generator")
	@SequenceGenerator(name="heroi_generator", sequenceName = "heroi_seq", allocationSize=50)
	private Integer id;
	
	private String heroi;
	
	private Integer pontosDeVida;
	private Integer forca;
	private Integer defesa;
	private Integer agilidade;
	private Integer qtdDadosDano;
	private Integer tamanhoDadosDano;
	
	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}
}
