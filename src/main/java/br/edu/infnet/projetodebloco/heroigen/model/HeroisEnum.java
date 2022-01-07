package br.edu.infnet.projetodebloco.heroigen.model;

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
