package edu.projeto.integrador.imdaz.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Aluno extends Pessoa {
    private String escola;
    private String matricula;
    private boolean possuiAgua;
    private boolean possuiLuz;
    private double mediaNotas;
    private String anoLetivo;  // Corrigi para anoLetivo (letras minúsculas, por convenção)
    private Responsavel responsavel;  // Responsável do aluno

    // Construtor manual com todos os parâmetros
    public Aluno(String nome, String escola, String matricula, boolean possuiAgua, boolean possuiLuz, double mediaNotas, String anoLetivo, Responsavel responsavel) {
        super(nome);  // Chama o construtor da classe Pessoa (nome é herdado de Pessoa)
        this.escola = escola;
        this.matricula = matricula;
        this.possuiAgua = possuiAgua;
        this.possuiLuz = possuiLuz;
        this.mediaNotas = mediaNotas;
        this.anoLetivo = anoLetivo;
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Aluno: " + getNome() + ", Escola: " + escola + ", Matrícula: " + matricula + ", Responsável: " + (responsavel != null ? responsavel.getNome() : "Não informado");
    }
}
