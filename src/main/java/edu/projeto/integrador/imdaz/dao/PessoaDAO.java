package edu.projeto.integrador.imdaz.dao;

import edu.projeto.integrador.imdaz.connector.PostgresConnector;
import edu.projeto.integrador.imdaz.lista.ListaEncadeada;
import edu.projeto.integrador.imdaz.model.Genero;
import edu.projeto.integrador.imdaz.model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// Classe DAO, responsável pela conexão e operações de banco de dados para a entidade Pessoa.
public class PessoaDAO {
    private PostgresConnector connector;
    // Construtor que recebe uma instância do PostgresConnector para estabelecer a conexão com o banco de dados
    public PessoaDAO(PostgresConnector connector) {
        this.connector = connector;
    }
    // Metodo para criar uma nova pessoa no banco de dados. Utiliza o RETURNING para pegar o ID gerado automaticamente pelo banco.
    public int create(Pessoa pessoa) {
        try {
            PreparedStatement stmt = this.connector.getPreparedStatement(
                    "INSERT INTO pessoa (nome, data_nasc, telefone, genero, endereco_id) " +
                            "VALUES (?, ?, ?, ?, ?) RETURNING pessoa_id;"
            );

            stmt.setString(1, pessoa.getNome());
            stmt.setDate(2, new java.sql.Date(pessoa.getDataNascimento().getTime()));
            stmt.setString(3, pessoa.getTelefone());
            stmt.setObject(4, pessoa.getGenero(), java.sql.Types.OTHER);
            stmt.setInt(5, pessoa.getEnderecoId());

            // Executa a query e obtém o ID gerado
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int pessoaId = rs.getInt("pessoa_id");
                pessoa.setPessoaId(pessoaId); // Atribui o ID gerado à pessoa
                System.out.println("Pessoa inserida com sucesso! pessoa_id: " + pessoaId);
                return pessoaId;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Pessoa", e);
        }

        return 0; // Caso não retorne o ID
    }



// Metodo para ler todos as pessoas possíveis do banco de dados, utilizando a lista encadeada
    public ListaEncadeada read() {
        ListaEncadeada listaPessoas = new ListaEncadeada();
        try {
            PreparedStatement stmt = this.connector.getPreparedStatement("SELECT * FROM pessoa;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Pessoa pessoa = new Pessoa();
                pessoa.setNome(rs.getString("nome"));
                // Recuperando e convertendo a data para java.util.Date
                java.sql.Date sqlDate = rs.getDate("data_nasc");
                if (sqlDate != null) {
                    pessoa.setDataNascimento(new java.util.Date(sqlDate.getTime()));  // Converte para java.util.Date
                } else {
                    pessoa.setDataNascimento(null);  // Caso a data seja null no banco
                }
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setGenero(Genero.valueOf(rs.getString("genero")));
                pessoa.setEnderecoId(rs.getInt("endereco_id"));
                pessoa.setPessoaId(rs.getInt("pessoa_id")); // esse por último, tanto faz


                listaPessoas.adicionaPessoa(pessoa);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar pessoas", e);
        }
        return listaPessoas;
    }
// metodo update, para atualizar alguma pessoa especifica, na main utilizasse também do GetById
    public void update(Pessoa pessoa) {
        try {
            PreparedStatement stmt = this.connector.getPreparedStatement("""
    UPDATE pessoa 
    SET nome = ?, data_nasc = ?, telefone = ?, genero = ?::genero_enum, endereco_id = ?
    WHERE pessoa_id = ?;
""");


            // Setar os parâmetros
            stmt.setString(1, pessoa.getNome());
            stmt.setDate(2, new java.sql.Date(pessoa.getDataNascimento().getTime()));
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(4, pessoa.getGenero().name());
            stmt.setInt(5, pessoa.getEnderecoId());
            stmt.setInt(6, pessoa.getPessoaId());  // Aqui você passa o ID para especificar qual registro vai ser atualizado.

            // Executar o update
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar pessoa", e);
        }
    }
    public void delete(int pessoaId) {
        try {
            // Primeiro, deletar o aluno que tem essa pessoa_id
            PreparedStatement deleteAluno = this.connector.getPreparedStatement(
                    "DELETE FROM aluno WHERE pessoa_id = ?;"
            );
            deleteAluno.setInt(1, pessoaId);
            deleteAluno.executeUpdate();

            // Agora, deleta a pessoa
            PreparedStatement stmt = this.connector.getPreparedStatement(
                    "DELETE FROM pessoa WHERE pessoa_id = ?;"
            );
            stmt.setInt(1, pessoaId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir pessoa", e);
        }
    }
    public Pessoa getById(int id) {
        String sql = """
        SELECT pessoa_id, nome, data_nasc, telefone, genero, endereco_id
        FROM pessoa
        WHERE pessoa_id = ?;
    """;

        try (PreparedStatement stmt = connector.getPreparedStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                return null;  // não encontrou
            }

            Pessoa p = new Pessoa();
            p.setPessoaId(rs.getInt("pessoa_id"));
            p.setNome(rs.getString("nome"));
            java.sql.Date sqlDate = rs.getDate("data_nasc");
            if (sqlDate != null) {
                p.setDataNascimento(new java.util.Date(sqlDate.getTime()));
            }
            p.setTelefone(rs.getString("telefone"));
            p.setGenero(Genero.valueOf(rs.getString("genero")));
            p.setEnderecoId(rs.getInt("endereco_id"));
            return p;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar pessoa por ID", e);
        }
    }


}
