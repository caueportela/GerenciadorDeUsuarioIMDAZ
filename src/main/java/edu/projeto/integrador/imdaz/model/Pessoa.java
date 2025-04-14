package edu.projeto.integrador.imdaz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Pessoa {
    private String nome;
    private boolean recebeBolsa;
    private Date dataNascimento;
    private boolean alfabetizado;
    private String endereco;
    private String documento;
    private String telefone;
    private Genero genero;

    public Pessoa() {

    }
//Construtor = utilizado para inicializar os objetos

    public Pessoa(String nome, Genero genero, boolean recebeBolsa, Date dataNascimento, boolean alfabetizado, String endereco, String documento, String telefone) {
        this.nome = nome;   // Palavra this é utilizado para acessar o atributo dentro da classe Pessoa
        this.genero = genero;
        this.recebeBolsa = recebeBolsa;
        this.dataNascimento = dataNascimento;
        this.alfabetizado = alfabetizado;
        this.endereco = endereco;
        this.documento = documento;
        this.telefone = telefone;
    }
@Override
public String toString() {
        return "Nome: " + nome;
}

    public Pessoa(String nome) {
    }
}


