package br.edu.infnet.projetodebloco.heroigen.model;

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
public class Heroi {

	private HeroisEnum heroi;
	
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
