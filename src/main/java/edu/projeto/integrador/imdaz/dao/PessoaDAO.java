package edu.projeto.integrador.imdaz.dao;

import edu.projeto.integrador.imdaz.connector.PostgresConnector;
import edu.projeto.integrador.imdaz.model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {
    private PostgresConnector connector;

    public PessoaDAO(PostgresConnector connector) {
        this.connector = connector;
    }

    public void create(Pessoa pessoa) {
        try {
            PreparedStatement stmt = this.connector.getPreparedStatement("insert into pessoa(nome, genero, ) values();");
            stmt.executeUpdate();
         } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
