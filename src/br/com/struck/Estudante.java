package br.com.struck;

import java.time.LocalDate;

import br.com.struck.util.RandomGenerator;

public class Estudante {
	
	private static RandomGenerator rg = new RandomGenerator();

	private Long id;
	private String nomeInstituicaoEnsino;
	private String numeroMatricula;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	private String cpf;
	private String nomeMae;
	private String nomeCursoMatriculado;
	private String nivelEnsino;
	private String modalidadeEnsino;
	private Double percentualFrequencia;

	public Estudante() {

	}

	public Estudante(String instituicaoEnsino, String nomeCursoMatriculado,
					String modalidadeEnsino) {
		this.nomeInstituicaoEnsino = instituicaoEnsino;
		this.numeroMatricula = rg.getRandomNumeroMatricula();
		this.nomeCompleto = rg.getRandomFullName();
		this.dataNascimento = rg.getRandomBirthDate();
		this.cpf = rg.getRandomCpf();
		this.nomeMae = rg.getRandomFemaleName();
		this.nomeCursoMatriculado = nomeCursoMatriculado;
		this.nivelEnsino = rg.getRandomNivelEnsino();
		this.modalidadeEnsino = modalidadeEnsino;
		this.percentualFrequencia = rg.getRandomPercentualFrequenciaEscolar();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeInstituicaoEnsino() {
		return nomeInstituicaoEnsino;
	}

	public void setNomeInstituicaoEnsino(String nomeInstituicaoEnsino) {
		this.nomeInstituicaoEnsino = nomeInstituicaoEnsino;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomeCursoMatriculado() {
		return nomeCursoMatriculado;
	}

	public void setNomeCursoMatriculado(String nomeCursoMatriculado) {
		this.nomeCursoMatriculado = nomeCursoMatriculado;
	}

	public String getNivelEnsino() {
		return nivelEnsino;
	}

	public void setNivelEnsino(String nivelEnsino) {
		this.nivelEnsino = nivelEnsino;
	}

	public String getModalidadeEnsino() {
		return modalidadeEnsino;
	}

	public void setModalidadeEnsino(String modalidadeEnsino) {
		this.modalidadeEnsino = modalidadeEnsino;
	}

	public Double getPercentualFrequencia() {
		return percentualFrequencia;
	}

	public void setPercentualFrequencia(Double percentualFrequencia) {
		this.percentualFrequencia = percentualFrequencia;
	}

}
