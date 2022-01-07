package br.edu.infnet.projetodebloco.heroigen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class ItemRanking {

	@Id @GeneratedValue
	private Integer id;
	
	private Integer posicao;

	private String idBatalha;
	private String usuario;

	private Integer pontuacao;

	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
