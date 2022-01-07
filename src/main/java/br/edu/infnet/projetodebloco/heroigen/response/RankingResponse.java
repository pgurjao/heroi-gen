package br.edu.infnet.projetodebloco.heroigen.response;

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
public class RankingResponse {
	
	private Integer posicao;
	
	private String idBatalha;

	private String usuario;

	private Integer pontuacao;
	
	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
