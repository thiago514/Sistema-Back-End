
# CRUD para gerenciamento de pessoas e Endereços

Esse projeto foi feito para fazer o gerenciamento de Pessoas e de seus endereços em uma plataforma online

## 💬 Analise de Requisitos

caso tenha interesse de ver como foi feita a analise de requisitos para fazer o projeto **[click aqui](https://github.com/thiago514/Teste-Tecnico-Back-End---Attornatus/blob/main/Analise_de_requisitos/AnaliseDeRequisitos.md)**

## 🚀 Começando

Essas instruções permitirão que obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

### 📋 Pré-requisitos

De que coisas você precisa para instalar o software e como instalá-lo?

```
Java 17
Maven 3.8.1
```

### 🔧 Instalação

Para a instação será necessario ir à pasta raiz do projeto e executar o seguinte comando

```
mvn compile
```
Esse comando vai fazer com que o projeto seja compilado.

Após fazer a compilação do projeto para fazer a execução basta fazer o seguinte comando

```
mvn spring-boot:run -Dspring.profiles.active=dev
```

Com isso, o projeto estara rodando na máquina local para testar a API

## ⚙️ Executando os testes

Para a execução dos testes do projeto será necessario ir à pasta raiz do projeto e executar o seguinte comando

```
mvn test
```

Com isso, o Maven vai executar todos os testes contidos no projeto

### Testes de requisições
Para fazer os testes na API ela vai estar nativamente rodando na porta 8080
Para quendo estiver rodando na maquina local vai ser o seguinte link
```
http://localhost:8080/
```
Caso você queira ver alguns exemplos de JSON para testar **[clique aqui](https://github.com/thiago514/Teste-Tecnico-Back-End---Attornatus/blob/main/Analise_de_requisitos/AnaliseDeRequisitos/Comandos%20e%20formatos%20JSON%20para%20a%20API.md)**
## 🛠️ Construído com


* [Spring](https://spring.io/) - O framework utilizado
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [JUnit 5](https://junit.org/junit5/) - Testes
* [Model Mapper](https://modelmapper.org/) - Mapeador de Objetos
* [dataBase h2](h2database.com/) - Banco de dados

## ✒️ Autor

**[Thiago Gogola Milagres](https://github.com/thiago514/)**
