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
public class LogTurnoBatalhaResponse {
	
	private Integer status;
	
	private String details;
	
	private String errors;
	
	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}

}
