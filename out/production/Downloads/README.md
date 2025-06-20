
# Sistema CRUD de Funcionários em Java Desktop

Projeto simples para gerenciar funcionários (CRUD) com:

- Java Desktop (Swing)
- MySQL para persistência de dados
- Arquitetura MVC (Model, View, Controller)

## Estrutura de diretórios

```
src/
├── controller/         # Controladores (lógica de controle)
│   └── FuncionarioController.java
├── model/              # Modelos e acesso a dados (DAO)
│   ├── Funcionario.java
│   └── FuncionarioDAO.java
├── util/               # Utilitários (ex: conexão com BD)
│   └── Conexao.java
└── view/               # Interface gráfica (Swing)
    └── FuncionarioView.java
Main.java               # Classe principal para iniciar o programa
```

## Configuração do banco de dados

- Crie um banco MySQL e configure a tabela `funcionario` com os campos:
  - `id` INT AUTO_INCREMENT PRIMARY KEY
  - `nome` VARCHAR(100)
  - `email` VARCHAR(100)
  - `cargo` VARCHAR(50)
  - `salario` DOUBLE

- Atualize o arquivo `Conexao.java` com as credenciais do seu banco.

## Executando o projeto

- Compile os arquivos `.java` dentro da pasta `src`.
- Execute a classe `Main`.
- A interface permite adicionar, listar e remover funcionários.

---
