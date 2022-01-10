package br.edu.infnet.projetodebloco.heroigen.request;

import javax.validation.constraints.NotBlank;

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
public class RankingRequest {
	
	@NotBlank(message = "batalhaId não pode ser vazio")
	private String batalhaId;
	
	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
