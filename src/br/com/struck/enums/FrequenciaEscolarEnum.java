package br.com.struck.enums;

public enum FrequenciaEscolarEnum {
	ALTA(100.00), MEDIA_ALTA(82.50), MEDIA(50.00), MEDIA_INFERIOR(25.00), INFERIOR(10.00);

	private Double frequencia;

	FrequenciaEscolarEnum(Double frequencia) {
		this.frequencia = frequencia;
	}

	public Double value() {
		return frequencia;
	}

}
