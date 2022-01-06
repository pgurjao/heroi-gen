package br.edu.infnet.projetodebloco.heroigen.model;

public enum HeroisEnum {
	
	ARQUEIRO("Arqueiro"), ANAO("Anão"), MAGO("Mago");

	private final String heroi;

	HeroisEnum(String heroi) {
		this.heroi = heroi;
	}

	public String getHeroi() {
		return heroi;
	}

}
