package edu.projeto.integrador.imdaz.dao;

import edu.projeto.integrador.imdaz.connector.PostgresConnector;
import edu.projeto.integrador.imdaz.model.Endereco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDAO {
    private PostgresConnector connector;

    public EnderecoDAO(PostgresConnector connector) {
        this.connector = connector;
    }
// Metodo para criar o endereco
    public int create(Endereco endereco) {
        try {
            PreparedStatement stmt = this.connector.getPreparedStatement(
                    "INSERT INTO endereco (bairro, rua, numero, CEP) VALUES (?, ?, ?, ?) RETURNING endereco_id;"
            );

            stmt.setString(1, endereco.getBairro());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getNumero());
            stmt.setString(4, endereco.getCEP());

            var rs = stmt.executeQuery();
            if (rs.next()) {
                int enderecoId = rs.getInt("endereco_id");
                endereco.setEnderecoId(enderecoId);
                System.out.println("Endereço inserido com sucesso! endereco_id: " + enderecoId);
                return enderecoId;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Endereço", e);
        }

        return 0;
    }
}
