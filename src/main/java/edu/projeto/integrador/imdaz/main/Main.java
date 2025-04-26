package edu.projeto.integrador.imdaz.main;

import edu.projeto.integrador.imdaz.connector.PostgresConnector;
import edu.projeto.integrador.imdaz.dao.AlunoDAO;
import edu.projeto.integrador.imdaz.dao.EnderecoDAO;
import edu.projeto.integrador.imdaz.dao.PessoaDAO;
import edu.projeto.integrador.imdaz.dao.ResponsavelDAO;
import edu.projeto.integrador.imdaz.lista.ListaEncadeada;
import edu.projeto.integrador.imdaz.model.Aluno;
import edu.projeto.integrador.imdaz.model.Genero;
import edu.projeto.integrador.imdaz.model.Pessoa;
import edu.projeto.integrador.imdaz.model.Responsavel;
import lombok.Getter;
import lombok.Setter;
import edu.projeto.integrador.imdaz.service.PessoaService;

import java.sql.SQLException;
import java.util.Scanner;

@Getter
@Setter
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        // Criando a Conexão com o banco de dados
        PostgresConnector connector = PostgresConnector.getInstance();
        // Instanciando os DAOs
        PessoaDAO pessoaDAO = new PessoaDAO(connector);
        EnderecoDAO enderecoDAO = new EnderecoDAO(connector);
        AlunoDAO alunoDAO = new AlunoDAO(connector);
        ResponsavelDAO responsavelDAO = new ResponsavelDAO(connector);

        // Menu do IMDAZ, com as opções do CRUD.
        System.out.println("---Bem vindo ao Gerenciador de Pessoas do IMDAZ!---");
        System.out.println("Escolha uma opção:");
        System.out.println(" 1 -- Cadastrar Aluno");
        System.out.println(" 2 -- Cadastrar Responsável");
        System.out.println(" 3 -- Listar Pessoas");
        System.out.println(" 4 -- Atualizar Pessoa");
        System.out.println(" 5 -- Deletar Pessoa");
        System.out.println(" 6 -- Sair");
        int opcao = sc.nextInt();
        sc.nextLine(); // evitar quebra de linha

        if (opcao == 1) {

            Pessoa pessoa = PessoaService.CadastrarPessoa(sc, pessoaDAO, enderecoDAO);
              // chama o metodo CadastrarPessoa criado com perguntas padrões para evitar códigos desnecessários no main

            System.out.println("Digite a escola:");
            String escola = sc.nextLine();
            System.out.println("Digite a matricula:");
            String matricula = sc.nextLine();
            System.out.println("Possui laudo?");
            Boolean possui_laudo = sc.nextBoolean();
            System.out.println("Digite a média Escolar:");
            double mediaNotas = sc.nextDouble();
            sc.nextLine(); // limpar quebra de linha
            System.out.println("Digite o ano letivo");
            String anoLetivo = sc.nextLine();

            Aluno aluno = new Aluno(pessoa.getPessoaId(), escola, matricula, possui_laudo, mediaNotas, anoLetivo, pessoa.getEnderecoId());
            alunoDAO.create(aluno);
            System.out.println("Aluno cadastrado com sucesso!");
        } else if (opcao == 2) {
            Pessoa pessoa = PessoaService.CadastrarPessoa(sc, pessoaDAO, enderecoDAO);

            System.out.println("Qual o parentesco:");
            String Parentesco = sc.nextLine();
            System.out.println("Tem a guarda do aluno?");
            Boolean guardiao_legal = sc.nextBoolean();
            Responsavel responsavel = new Responsavel(pessoa.getPessoaId(), Parentesco, guardiao_legal);
            responsavelDAO.create(responsavel);
            System.out.println("Responsável cadastrado com sucesso!");
        }
        else if (opcao == 3) {
            System.out.println("Lista de pessoas:");
            ListaEncadeada lista = pessoaDAO.read();  // Lê todas as pessoas do banco
            lista.imprimeLista();  // Chama a funçao/metodo que imprime a lista
        }
else if (opcao == 4) {
    System.out.println("Insira o id da pessoa que quer atualizar: ");
    int pessoaId = sc.nextInt();
            Pessoa pessoa = pessoaDAO.getById(pessoaId);
            if (pessoa == null) {
                System.out.println("Pessoa não encontrada com o ID informado.");
            } else {
                System.out.println("Nome atual: " + pessoa.getNome());
                System.out.print("Novo nome (ou ENTER para não alterar): ");
                String nome = sc.nextLine();
                if (!nome.isBlank()) {
                    pessoa.setNome(nome);
                }

                System.out.println("Data de nascimento atual: " + pessoa.getDataNascimento());
                sc.nextLine();
                System.out.print("Nova data (yyyy-MM-dd) (ou ENTER): ");
                String data = sc.nextLine();
                if (!data.isBlank()) {
                    pessoa.setDataNascimento(java.sql.Date.valueOf(data));
                }

                System.out.println("Telefone atual: " + pessoa.getTelefone());
                System.out.print("Novo telefone (ou ENTER): ");
                String tel = sc.nextLine();
                if (!tel.isBlank()) {
                    pessoa.setTelefone(tel);
                }

                System.out.println("Gênero atual: " + pessoa.getGenero());
                System.out.print("Novo gênero (MASCULINO, FEMININO) (ou ENTER): ");
                String gen = sc.nextLine();
                if (!gen.isBlank()) {
                    pessoa.setGenero(Genero.valueOf(gen));
                }

                System.out.println("Endereço atual (ID): " + pessoa.getEnderecoId());
                System.out.print("Novo endereço (ID) (ou ENTER): ");
                String end = sc.nextLine();
                if (!end.isBlank()) {
                    pessoa.setEnderecoId(Integer.parseInt(end));
                }

                // chama o update no DAO
                pessoaDAO.update(pessoa);
                System.out.println("Pessoa atualizada com sucesso!");
            }
        }
else if (opcao == 5) {
            System.out.print("Digite o ID da pessoa que deseja deletar: ");
            int PessoaParaDeletar = sc.nextInt();
            sc.nextLine();
            pessoaDAO.delete(PessoaParaDeletar);
            System.out.println("Pessoa deletada com sucesso!");
        }
else if (opcao == 6) {
    System.out.println("Sistema encerrado com sucesso!");
        }
        PostgresConnector.close(); // Fecha a conexão com o banco de dados para parar de enviar recurso
        }

    }

