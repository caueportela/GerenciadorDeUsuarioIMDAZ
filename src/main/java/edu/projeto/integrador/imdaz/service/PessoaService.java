package edu.projeto.integrador.imdaz.service;

import edu.projeto.integrador.imdaz.dao.EnderecoDAO;
import edu.projeto.integrador.imdaz.dao.PessoaDAO;
import edu.projeto.integrador.imdaz.model.Endereco;
import edu.projeto.integrador.imdaz.model.Genero;
import edu.projeto.integrador.imdaz.model.Pessoa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class PessoaService {
// Metodo criado para criar um padrão de pessoa, evitando congestionamento de código na main, já que tanto um responsável quanto um aluno são pessoas.
public static Pessoa CadastrarPessoa(Scanner sc, PessoaDAO pessoaDAO, EnderecoDAO enderecoDAO){

    System.out.println("Digite o nome da pessoa: ");
    String nome = sc.nextLine();

    System.out.println("Digite a data de nascimento (yyyy-MM-dd): ");
    String dataNascimentoStr = sc.nextLine();
    Date dataNascimento = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
        dataNascimento = sdf.parse(dataNascimentoStr);
    } catch (Exception e) {
        System.out.println("Erro ao converter a data.");
        e.printStackTrace();
    }

    System.out.print("Telefone: ");
    String telefone = sc.nextLine();
    System.out.print("Gênero (Masculino ou Feminino): ");
    String generoStr = sc.nextLine();
    Genero genero = Genero.valueOf(generoStr.toUpperCase());
    System.out.println("Digite os dados do Endereço:");
    System.out.print("Bairro: ");
    String bairro = sc.nextLine();
    System.out.print("Rua: ");
    String rua = sc.nextLine();
    System.out.print("Número: ");
    String numero = sc.nextLine();
    System.out.print("CEP: ");
    String CEP = sc.nextLine();

    Endereco endereco = new Endereco(bairro, rua, numero, CEP);
    enderecoDAO.create(endereco);

    Pessoa pessoa = new Pessoa(nome, dataNascimento, telefone, genero, endereco.getEnderecoId());
    int pessoaId = pessoaDAO.create(pessoa);
    pessoa.setPessoaId(pessoaId);
    return pessoa;
}

}
