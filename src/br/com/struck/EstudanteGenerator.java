package br.com.struck;

import java.util.ArrayList;

public class EstudanteGenerator {

	public Estudante getRandomEstudante(String instituicaoEnsino, String nomeCursoMatriculado,
					String modalidadeEnsino) {
		return new Estudante(instituicaoEnsino, nomeCursoMatriculado, modalidadeEnsino);
	}

	public ArrayList<Estudante> getRandomEstudantes(String instituicaoEnsino,
					String nomeCursoMatriculado, String modalidadeEnsino, Long quantity) {
		ArrayList<Estudante> toReturn = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			toReturn.add(getRandomEstudante(instituicaoEnsino, nomeCursoMatriculado,
							modalidadeEnsino));
		}
		return toReturn;
	}

}
