package br.com.struck.util;

import br.com.struck.Estudante;

public class QueryGenerator {
	private StringBuilder sb = new StringBuilder();
	private static long id = 1;

	public String getValueLine(Estudante estudante) {
		sb.append("(")
			.append(id++ + ",")
			.append("'" + estudante.getNomeInstituicaoEnsino() + "',")
			.append("'" + estudante.getNumeroMatricula() + "',")
			.append("'" + estudante.getNomeCompleto() + "',")
			.append("'" + estudante.getDataNascimento().toString() + "',")
			.append("'" + estudante.getCpf() + "',")
			.append("'" + estudante.getNomeMae() + "',")
			.append("'" + estudante.getNomeCursoMatriculado() + "',")
			.append("'" + estudante.getNivelEnsino() + "',")
			.append("'" + estudante.getModalidadeEnsino() + "',")
			.append(estudante.getPercentualFrequencia() + "),");
		String line = sb.toString();
		sb.delete(0, sb.length());
		return line;
	}
}
