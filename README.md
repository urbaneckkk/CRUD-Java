
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

- Acesse: https://dev.mysql.com/downloads/connector/j/

Clique em "Download" > Platform Independent > baixe o .zip

Extraia e procure o arquivo: mysql-connector-j-8.0.xx.jar

- Adicione o .jar presente no arquivo como librarie
- 1: vá em File e depois em Project Structure
- 2: na esquerda em librarie clique no +
- 3: adicione o mysql-connector-j-x.x.x e clique em ok e depois em aplicar
- Compile os arquivos `.java` dentro da pasta `src`.
- Execute a classe `Main`.
- A interface permite adicionar, listar e remover funcionários.

---
