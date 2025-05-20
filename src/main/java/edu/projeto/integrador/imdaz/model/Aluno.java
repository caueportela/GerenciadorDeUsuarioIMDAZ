package edu.projeto.integrador.imdaz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Getters e Setters para acessar os atributos de alunos em outras classes.
public class Aluno extends Pessoa {
    private String escola;
    private String matricula;
    private boolean possui_laudo;
    private double mediaNotas;
    private String anoLetivo;

    // Construtor completo com herança
    public Aluno(int pessoaId, String escola, String matricula, Boolean possuiLaudo, double mediaNotas, String anoLetivo, int enderecoId) {
        this.setPessoaId(pessoaId); // herdado de Pessoa
        this.setEnderecoId(enderecoId); // herdado de Pessoa
        this.escola = escola;
        this.matricula = matricula;
        this.possui_laudo = possuiLaudo;
        this.mediaNotas = mediaNotas;
        this.anoLetivo = anoLetivo;
    }

    // Construtor alternativo com um objeto Pessoa
    public Aluno(String escola, String matricula, boolean possui_laudo, double mediaNotas, String anoLetivo, Pessoa pessoa) {
        this.escola = escola;
        this.matricula = matricula;
        this.possui_laudo = possui_laudo;
        this.mediaNotas = mediaNotas;
        this.anoLetivo = anoLetivo;
        this.setPessoaId(pessoa.getPessoaId()); // herdado de Pessoa
        this.setEnderecoId(pessoa.getEnderecoId()); // herdado de Pessoa
        this.setNome(pessoa.getNome());
        this.setDataNascimento(pessoa.getDataNascimento());
        this.setTelefone(pessoa.getTelefone());
        this.setGenero(pessoa.getGenero());
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "pessoaId=" + getPessoaId() +
                ", nome='" + getNome() + '\'' +
                ", escola='" + escola + '\'' +
                ", matricula='" + matricula + '\'' +
                ", possui_laudo=" + possui_laudo +
                ", mediaNotas=" + mediaNotas +
                ", anoLetivo='" + anoLetivo + '\'' +
                '}';
    }
}
