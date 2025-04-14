package edu.projeto.integrador.imdaz.lista;

import edu.projeto.integrador.imdaz.model.Aluno;

public class ListaEncadeada {
    private Node primeiro;
    private Node ultimo;
    private int tamanho = 0;

    public ListaEncadeada() {
        primeiro = null;
        ultimo = null;
    }

    public void adicionaAluno(Aluno aluno) {
        Node novo = new Node(aluno);
        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            ultimo = novo;
        }
        tamanho++;
    }

    public void imprimeLista() {
        Node atual = primeiro;
        while (atual != null) {
            System.out.println(atual.getAluno()); // ou atual.getAluno().getNome()
            atual = atual.getProximo();
        }
    }

    public int getTamanho() {
        return tamanho;
    }
}
