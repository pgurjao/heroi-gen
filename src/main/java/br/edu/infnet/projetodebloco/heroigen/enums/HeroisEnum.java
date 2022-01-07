package br.edu.infnet.projetodebloco.heroigen.enums;

public enum HeroisEnum {
	
	GUERREIRO("Guerreiro"), BARBARO("Barbaro"), PALADINO("Paladino");

	private final String heroi;

	HeroisEnum(String heroi) {
		this.heroi = heroi;
	}

	public String getHeroi() {
		return heroi;
	}

}
