# FanProfiler

FanProfiler é uma solução para coleta e validação de informações sobre fãs de esports, incluindo dados pessoais, alterar, criar, deletar busca fãs.

## Tecnologias Utilizadas
- **Backend**: Spring Boot (Java)
- **Banco de Dados**: H2 (para desenvolvimento e testes)

## Funcionalidades
- Cadastro de fãs com dados pessoais e preferências.
- Armazenamento seguro das informações.

## Como Rodar o Projeto

### 1. **Clonar o Repositório**
```bash
git clone https://github.com/usuario/fanprofiler.git
cd fanprofiler
2. Configuração do Ambiente
Para rodar o projeto, você precisará do Java (JDK 17 ou superior) e Maven instalados.

Java JDK 17: Instalar JDK

Maven: Instalar Maven

3. Rodar o Backend
No diretório raiz do projeto, rode o seguinte comando para iniciar o backend:
mvn spring-boot:run
Isso iniciará a aplicação Spring Boot no endereço http://localhost:8080.

4. Acessar o Console do H2
Acesse o console do banco de dados H2 no navegador:
http://localhost:8080/h2-console
Use as credenciais:

JDBC URL: jdbc:h2:mem:testdb

Username: admin

Password: admin

5. Usando a API
A API está disponível na URL http://localhost:8080/fans. Você pode testar os endpoints usando ferramentas como o Postman.

Endpoints:
GET /fans: Retorna todos os fãs cadastrados.

POST /fans: Cria um novo fã.

GET /fans/{id}: Retorna os detalhes de um fã.

PUT /fans/{id}: Atualiza os dados de um fã.

DELETE /fans/{id}: Deleta um fã.
