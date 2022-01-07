package br.edu.infnet.projetodebloco.heroigen.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class LogTurnoBatalha {
	
	@NotBlank(message = "idBatalha não pode ser vazio")
	private String idBatalha;
	
	@NotBlank(message = "Usuario não pode ser vazio")
	private String usuario;
	
	@NotBlank(message = "Heroi não pode ser vazio")
	private String heroi;

	@NotBlank(message = "Monstro não pode ser vazio")
	private String monstro;
	
	@NotBlank(message = "Iniciativa não pode ser vazio")
	private String iniciativa;
	
	@Min(value = 0, message="Dano não pode ser negativo")
	@Max(value = 18, message="Dano não pode ser maior que 18")
	@NotNull(message = "Dano não pode ser null")
	private Integer dano;
	
	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
