package edu.projeto.integrador.imdaz.lista;

import edu.projeto.integrador.imdaz.model.Aluno;

public class Node {
    private Aluno aluno;
    private Node proximo;

    public Node(Aluno aluno) {
        this.aluno = aluno;
        this.proximo = null;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
