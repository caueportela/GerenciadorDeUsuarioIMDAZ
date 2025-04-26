package edu.projeto.integrador.imdaz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
// Construtor com todos os parâmetros
public class Pessoa {
    private int pessoaId;  // O ID da pessoa que é gerado pelo banco de dados
    private String nome;
    private Date dataNascimento;
    private String telefone;
    private Genero genero;
    private int enderecoId;  // ID do endereço, necessário para a inserção no banco

    public Pessoa(String nome, Date dataNascimento, String telefone, Genero genero, int enderecoId) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;  // Agora a data é do tipo Date
        this.telefone = telefone;
        this.genero = genero;
        this.enderecoId = enderecoId;
    }

    public Pessoa() {

    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Pessoa{" +
                "pessoaId=" + pessoaId +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + sdf.format(dataNascimento) +
                ", telefone='" + telefone + '\'' +
                ", genero=" + genero +
                ", enderecoId=" + enderecoId +
                '}';
    }

}
