package br.com.struck.enums;

public enum ArquivosEnum {
	MASC("resources/nomes-masculinos.txt"),
	FEM("resources/nomes-femininos.txt"),
	SN("resources/sobrenomes.txt");
	
	private String nomeArquivo;
	
	ArquivosEnum(String arquivo) {
		this.nomeArquivo = arquivo;
	}
	
	public String nome() {
		return nomeArquivo;
	}
	
}
