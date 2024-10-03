# TodoList

Esse projeto tem como intuito te ajudar a organizar suas tarefas diárias. Ele foi feito em Java e usa um banco de dados MySQL para armazenar as informações.

## O que o TodoList faz?

- **Gerenciar Tarefas**: Você pode adicionar, editar e remover suas tarefas.
- **Buscar Tarefas**: É possível encontrar uma tarefa específica pelo ID ou pelo status (se foi "CRIADA", "INICICADA", "CONLCUIDA").
- **Verificação por Token**: O projeto usa um sistema de login, que consiste em um token adquirido após registrar o usuário. Passando o token como verificação é possivel registrar tarefas e realizar outras ações"
- **Tratamento de Erros**: Se algo não funcionar, o sistema informa o que aconteceu de forma clara.
- **Controle de Acesso**: Cada usuário só pode ver e gerenciar suas próprias tarefas.

## Tecnologias Utilizadas

- **Java**: A linguagem de programação usada para criar o projeto.
- **Spring Boot**: Uma ferramenta que facilita o desenvolvimento de aplicativos Java.
- **Spring Security**: Um sistema que protege as informações dos usuários.
- **JWT (JSON Web Token)**: Uma forma de autenticação segura.
- **MySQL**: Um banco de dados onde as tarefas são armazenadas.

## Como instalar

1. **Clone o repositório**: Faça uma cópia do projeto para o seu computador.
   ```bash
   git clone https://github.com/seu-usuario/todoList.git
   ```

2. **Entre na pasta do projeto**:
   ```bash
   cd todoList
   ```

3. **Configure o banco de dados**:
   - Crie um banco de dados chamado `todo_list` no MySQL.
   - Atualize as configurações de conexão no arquivo `application.properties`.

4. **Execute o projeto**: Comece a usar o aplicativo.
   ```bash
   mvn spring-boot:run
   ```

## Como usar

1. **Registrar**: Crie uma conta para começar a usar o aplicativo.
2. **Fazer Login**: Entre na sua conta para acessar suas tarefas.
3. **Gerenciar Tarefas**: Use as funções do aplicativo para adicionar, editar e remover tarefas.
4. **Requisições com Postman**: As requisições para a API podem ser feitas através do Postman. Você encontrará um documento com as informações sobre cada endpoint incluído no projeto.

## Contribuição

Se você quiser ajudar a melhorar o projeto, fique à vontade para sugerir ideias ou fazer alterações.

## Licença

Este projeto é aberto e você pode usá-lo à vontade. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

Se você tiver perguntas ou sugestões, entre em contato!
