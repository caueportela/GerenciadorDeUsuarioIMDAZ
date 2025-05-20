package edu.projeto.integrador.imdaz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//Getters e Setters para acessar os atributos de alunos em outras classes.
@NoArgsConstructor
@AllArgsConstructor

// Classe para criar o responsável, com os atributos como pessoaId, parentesco, guardião legal perante a lei.
public class Responsavel {
    private int pessoaId;
    private String parentesco;
    private Boolean guardiao_legal;

    @Override
    public String toString() {
        return "Responsável: " + pessoaId + ", Parentesco: " + parentesco + ", Guardião Legal: " + guardiao_legal;
    }

}
