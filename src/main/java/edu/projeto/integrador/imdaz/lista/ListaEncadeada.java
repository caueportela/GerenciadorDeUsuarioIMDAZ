package edu.projeto.integrador.imdaz.lista;

import edu.projeto.integrador.imdaz.model.Pessoa;

public class ListaEncadeada {
    private Node primeiro;
    private Node ultimo;
    private int tamanho = 0;

    public ListaEncadeada() {
        primeiro = null; // Construtor, inicia com null pois ela está vazia
        ultimo = null;
    }

    // Método para adicionar Pessoa, recebe um objeto Pessoa e cria um novo objeto Node que armazena a pessoa passada como parâmetro.
    public void adicionaPessoa(Pessoa pessoa) {
        Node novo = new Node(pessoa);
        if (primeiro == null) { /* verifica se a lista está vazia, se estiver primeiro = novo */
            primeiro = novo;
            ultimo = novo; // ultimo = novo define o último nó como o mesmo nó, pois é o único na lista.
        } else {
            ultimo.setProximo(novo);
            ultimo = novo;
        }
        tamanho++;
    }

    // Método para imprimir a lista de pessoas
    public void imprimeLista() {
        Node atual = primeiro;
        while (atual != null) {
            Pessoa p = atual.getPessoa();  // Recupera o objeto Pessoa
            System.out.println("ID: " + p.getPessoaId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Data de nascimento: " + p.getDataNascimento());
            System.out.println("Telefone: " + p.getTelefone());
            System.out.println("Gênero: " + p.getGenero());
            System.out.println("ID do Endereço: " + p.getEnderecoId());
            System.out.println("-----------------------------------");
            atual = atual.getProximo();  // Vai para o próximo nó
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    // Classe interna Node (representando cada elemento da lista)
    private class Node {
        private Pessoa pessoa;
        private Node proximo;

        public Node(Pessoa pessoa) {
            this.pessoa = pessoa;
            this.proximo = null;
        }

        public Pessoa getPessoa() {
            return pessoa;
        }

        public void setProximo(Node proximo) {
            this.proximo = proximo;
        }

        public Node getProximo() {
            return proximo;
        }
    }
}
