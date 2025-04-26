package edu.projeto.integrador.imdaz.dao;

import edu.projeto.integrador.imdaz.connector.PostgresConnector;
import edu.projeto.integrador.imdaz.model.Responsavel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResponsavelDAO {
    private PostgresConnector connector;
// Construtor que recebe uma instância do PostgresConnector para estabelecer a conexão com o banco de dados
    public ResponsavelDAO(PostgresConnector connector) {
        this.connector = connector;
    }
// Metodo para criar o responsável
    public void create(Responsavel responsavel) {
        try {
            PreparedStatement stmt = this.connector.getPreparedStatement("""
                        INSERT INTO responsavel (pessoa_id, parentesco, guardiao_legal) VALUES (?, ?, ?);
                    """);
            stmt.setInt(1, responsavel.getPessoaId()); // ID da tabela pessoa
            stmt.setString(2, responsavel.getParentesco()); // Ex: "Mãe", "Pai"
            stmt.setBoolean(3, responsavel.getGuardiao_legal()); // true/false

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir responsável", e);
        }
    }
}
