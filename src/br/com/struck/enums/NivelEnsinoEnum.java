package br.com.struck.enums;

public enum NivelEnsinoEnum {
	FUNDAMENTAL("Fundamental"), MEDIO("Médio"), SUPERIOR("Superior");

	private String nivelEnsino;

	NivelEnsinoEnum(String nivelEnsino) {
		this.nivelEnsino = nivelEnsino;
	}

	public String value() {
		return nivelEnsino;
	}

}
