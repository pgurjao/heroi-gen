package br.edu.infnet.projetodebloco.heroigen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name = "ranking")
public class ItemRanking implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batalha_generator")
	@SequenceGenerator(name="batalha_generator", sequenceName = "batalha_seq", allocationSize=50)
	private Integer id;
	
	private Integer posicao;

	@Column(name = "batalha_id")
	private Integer batalhaId;
	
	private String usuario;

	private Integer pontuacao;

	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
