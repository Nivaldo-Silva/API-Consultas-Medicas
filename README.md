# API Consultas Médicas

Esta é uma API para gerenciar consultas médicas, construída com Spring Boot. A API permite criar, listar, atualizar, deletar e inativar consultas. A arquitetura segue o padrão de camadas (Controller, Model, DTO, Mapper, Service, Repository) e utiliza ModelMapper para a conversão entre entidades e DTOs.

## Tecnologias Utilizadas

* Java 21
* Spring Boot
* JPA/Hibernate
* PostgreSQL
* Lombok
* ModelMapper
* Jakarta Validation

## Estrutura do Projeto

O projeto segue uma arquitetura em camadas dividida nas seguintes partes:

* Controller: Camada responsável por expor os endpoints da API.
  
* Model: Representa a estrutura de dados que é persistida no banco de dados.
  
* Mapper: Responsável pela conversão entre objetos de diferentes camadas, como entre DTOs (Data Transfer Objects) e entidades JPA.
  
* Service: Camada responsável pela lógica de negócios.
  
* Repository: Camada responsável pela comunicação com o banco de dados.
  
* DTO: Objetos de Transferência de Dados usados para a comunicação entre as camadas.

## Endpoints

### Criar Consultas

* URL: /consultas
* Método: POST
* Descrição: Cria uma nova consulta.

### Listar Todas as Consultas

* URL: /consultas
* Método: GET
* Descrição: Lista todas as consultas.

### Buscar Consulta por ID

* URL: /consultas/{id}
* Método: GET
* Descrição: Busca uma consulta pelo ID.
  
### Atualizar Consulta

* URL: /consultas/{id}
* Método: PUT
* Descrição: Atualiza uma consulta existente.
  
### Inativar Consulta

* URL: /consultas/{id}
* Método: DELETE
* Descrição: Inativa uma consulta pelo ID.

### Instalação e Execução

### Clone o repositório

#### https:// github.com/seu-usuario/consultas-api.git

### Navegue até o diretório do projeto

#### cd consultas-api
  
### Compile e execute a aplicação  

#### . /mvnw spring-boot:run
  
#### A API estará disponível em <https://localhost:8080/consultas>
