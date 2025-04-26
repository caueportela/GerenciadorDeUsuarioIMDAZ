package edu.projeto.integrador.imdaz.dao;

import edu.projeto.integrador.imdaz.connector.PostgresConnector;
import edu.projeto.integrador.imdaz.model.Aluno;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {
    private PostgresConnector connector;

    public AlunoDAO(PostgresConnector connector) {
        this.connector = connector;
    }

    public int create(Aluno aluno) {
        try {
            // SQL para inserir dados na tabela 'aluno'
            PreparedStatement stmt = this.connector.getPreparedStatement(
                    "INSERT INTO aluno (pessoa_id, escola, matricula, possui_laudo, medianotas, anoletivo) VALUES (?, ?, ?, ?, ?, ?);"
            );

            // Definindo os parâmetros
            stmt.setInt(1, aluno.getPessoaId());  // Pessoa ID, que é a FK para pessoa
            stmt.setString(2, aluno.getEscola());  // Escola
            stmt.setString(3, aluno.getMatricula());  // Matrícula
            stmt.setBoolean(4, aluno.isPossui_laudo());  // Laudo
            stmt.setDouble(5, aluno.getMediaNotas());  // Média de notas
            stmt.setString(6, aluno.getAnoLetivo());  // Ano letivo

            // Executando a query
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Aluno", e);
        }

        return 0; // Retorna algum valor relevante (como o ID gerado), se necessário
    }
}
