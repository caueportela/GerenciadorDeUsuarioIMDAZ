# Gerenciador de Usuários - IMDAZ

Projeto desenvolvido para a disciplina de Projeto Integrador III-A, com o objetivo de modernizar o sistema de cadastro do IMDAZ, que antes era feito em planilhas.

## Funcionalidades

- Cadastro de alunos e responsáveis
- Associação de dados com a classe Pessoa (evita repetição)
- Integração com banco de dados PostgreSQL
- Uso de listas encadeadas e programação orientada a objetos

## Tecnologias

- Java
- PostgreSQL + JDBC
- Git

## Estrutura básica

- `model`: classes como Pessoa, Aluno, Responsavel
- `dao`: acesso ao banco
- `controller`: lida com a lógica dos cadastros
- `service`: regras de negócio (ex: PessoaService)
- `Main`: onde tudo roda e interage com o usuário

## Como usar

1. Clone o repositório:
```bash
git clone https://github.com/caueportela/GerenciadorDeUsuarioIMDAZ.git
