package br.edu.infnet.projetodebloco.heroigen.enums;

public enum IniciativaEnum {
	
	HEROI("Heroi"), MONSTRO("Monstro");

	private final String iniciativa;

	IniciativaEnum(String iniciativa) {
		this.iniciativa = iniciativa;
	}

	public String getIniciativa() {
		return iniciativa;
	}
	
}
