package edu.projeto.integrador.imdaz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    private int enderecoId;
    private String bairro;
    private String rua;
    private String numero;
    private String CEP;

    // Construtor com todos os atributos, menos o ID (que será gerado pelo banco)
    public Endereco(String bairro, String rua, String numero, String CEP) {
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.CEP = CEP;
    }

    // Construtor completo com ID (caso necessário)
    public Endereco(int enderecoId, String bairro, String rua, String numero, String CEP) {
        this.enderecoId = enderecoId;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.CEP = CEP;
    }

    @Override
    public String toString() {
        return "Endereco{" + "enderecoId=" + enderecoId + ", bairro='" + bairro + '\'' + ", rua='" + rua + '\'' + ", numero='" + numero + '\'' + ", CEP='" + CEP + '\'' + '}';
    }
}
