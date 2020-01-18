package br.com.struck.enums;

public enum ArquivosEnum {
	MASC("nomes-masculinos.txt"),
	FEM("nomes-femininos.txt"),
	SN("sobrenomes.txt");
	
	private String nomeArquivo;
	
	ArquivosEnum(String arquivo) {
		this.nomeArquivo = arquivo;
	}
	
	public String nome() {
		return nomeArquivo;
	}
	
}
