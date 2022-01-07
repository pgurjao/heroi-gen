package br.edu.infnet.projetodebloco.heroigen.enums;

public enum MonstrosEnum {
	
	MORTO_VIVO("Morto-Vivo"), ORC("Orc"), KOBOLD("Kobold");

	private final String monstro;

	MonstrosEnum(String monstro) {
		this.monstro = monstro;
	}

	public String getMonstro() {
		return monstro;
	}

}
