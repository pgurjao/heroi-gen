package br.edu.infnet.projetodebloco.heroigen.enums;

public enum AtacanteEnum {
	
	HEROI("Heroi"), MONSTRO("Monstro");

	private final String atacante;

	AtacanteEnum(String atacante) {
		this.atacante = atacante;
	}

	public String getAtacante() {
		return atacante;
	}
	
}
