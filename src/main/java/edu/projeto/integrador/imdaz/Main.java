package edu.projeto.integrador.imdaz;

import edu.projeto.integrador.imdaz.connector.PostgresConnector;
import edu.projeto.integrador.imdaz.dao.PessoaDAO;
import edu.projeto.integrador.imdaz.lista.ListaEncadeada;
import edu.projeto.integrador.imdaz.model.Pessoa;
import edu.projeto.integrador.imdaz.model.Aluno;
import edu.projeto.integrador.imdaz.model.Responsavel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PostgresConnector connector = PostgresConnector.getInstance();
        PessoaDAO pessoaDAO = new PessoaDAO(connector);
        pessoaDAO.create(new Pessoa());
        PostgresConnector.close();


        ListaEncadeada lista = new ListaEncadeada();
        Aluno aluno1 = new Aluno("Gabriel", "EScolaA", "203923", true, true, 8.0, "2025", new Responsavel());

    lista.adicionaAluno(aluno1);

    lista.imprimeLista();
    }
}