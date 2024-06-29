# Guia de Ajuda do Projeto Vacancy

Este documento fornece uma visão geral das tecnologias e ferramentas utilizadas no projeto Vacancy, além de instruções
sobre como configurar e executar o projeto localmente.

## Tecnologias e Ferramentas

O projeto Vacancy é desenvolvido com o uso de várias tecnologias e ferramentas importantes no ecossistema de
desenvolvimento Java, incluindo:

- **Spring Boot**: Uma plataforma poderosa para a construção de aplicações web e microserviços com o mínimo de
  configuração.
- **Spring Data JPA**: Facilita a implementação de camadas de acesso a dados, reduzindo a quantidade de código
  boilerplate.
- **Spring Security**: Oferece autenticação e autorização abrangentes para proteger a aplicação.
- **Flyway**: Uma ferramenta de controle de versão para bancos de dados que facilita a migração e o gerenciamento do
  esquema do banco de dados.
- **PostgreSQL**: Um sistema de gerenciamento de banco de dados relacional poderoso e de código aberto.
- **Docker Compose**: Uma ferramenta para definir e executar aplicações Docker multi-container.
- **Lombok**: Uma biblioteca Java que automaticamente pluga em seu editor e ferramentas de build, gerando código
  boilerplate.
- **JSON Web Token (JWT)**: Uma forma compacta e segura de transmitir informações entre partes como um objeto JSON.
- **Swagger**: Uma suíte de ferramentas de software para gerar documentação de APIs de forma automatizada.

## Configuração e Execução

Para configurar e executar o projeto Vacancy, siga os passos abaixo:

1. **Pré-requisitos**:
    - Instale o Java JDK 17.
    - Instale o Maven para gerenciar as dependências do projeto.
    - Instale o Docker e o Docker Compose para gerenciar containers e serviços.

2. **Clone o Repositório**:
    - Clone o código fonte do projeto para sua máquina local.

3. **Configuração do Banco de Dados**:
    - Utilize o Docker Compose para iniciar uma instância do PostgreSQL.
    - Execute o Flyway para aplicar as migrações do banco de dados.

4. **Construção do Projeto**:
    - Na raiz do projeto, execute o comando `mvn clean install` para construir o projeto e baixar as dependências
      necessárias.

5. **Execução do Projeto**:
    - Após a construção, execute o comando `mvn spring-boot:run` para iniciar a aplicação.

6. **Acesso à Aplicação**:
    - Com a aplicação em execução, você pode acessar os endpoints definidos através do navegador ou de ferramentas como
      Postman.
    - A documentação da API, gerada pelo Swagger, estará disponível para facilitar o teste e a integração com os
      endpoints.

## Documentação Adicional

Para mais informações sobre as tecnologias e ferramentas utilizadas, consulte a documentação oficial de cada uma delas.
Isso inclui guias de início rápido, tutoriais e referências de API que podem ajudar no desenvolvimento e na expansão do
projeto Vacancy.

# Visualizando a Documentação da API com Swagger

O projeto Vacancy utiliza Swagger para gerar documentação interativa da API, facilitando o entendimento e a utilização
dos endpoints disponíveis. Abaixo, você encontrará instruções sobre como acessar e interagir com a documentação da API
gerada pelo Swagger.

## Acessando a Documentação da API

Para visualizar a documentação da API:

1. **Inicie a Aplicação**: Certifique-se de que a aplicação Vacancy esteja em execução. Se necessário, siga as
   instruções de execução do projeto disponíveis no guia de ajuda.

2. **Abra o Navegador**: Com a aplicação em execução, abra o navegador de sua preferência.

3. **Acesse a Documentação**: Digite a URL da documentação da API gerada pelo Swagger. Normalmente, a URL segue o
   padrão `http://localhost:8080/swagger-ui/index.html`, substituindo `8080` pela porta em que sua aplicação está sendo
   executada, caso seja diferente.

## Interagindo com a Documentação

A documentação da API no Swagger UI é interativa, permitindo que você:

- **Explore os Endpoints**: Navegue pelos diferentes endpoints da API, visualizando os métodos HTTP disponíveis (GET,
  POST, PUT, DELETE, etc.), os parâmetros esperados e os modelos de dados.

- **Teste os Endpoints**: Execute chamadas para os endpoints diretamente da interface do Swagger. Para isso, clique
  sobre um endpoint para expandi-lo, preencha os parâmetros necessários e clique em "Try it out" e, em seguida, "
  Execute". Você poderá ver a resposta da API diretamente na interface.

- **Visualize os Modelos de Dados**: Acesse as definições dos modelos de dados utilizados pela API, incluindo estruturas
  de objetos e tipos de dados esperados.

## Benefícios da Documentação com Swagger

Utilizar o Swagger para documentar a API do projeto Vacancy oferece várias vantagens, como:

- **Facilidade de Uso**: A interface do Swagger é intuitiva, tornando fácil para desenvolvedores e usuários finais
  explorarem e testarem a API.

- **Atualização Automática**: A documentação é gerada automaticamente com base no código fonte, garantindo que as
  informações estejam sempre atualizadas com as últimas alterações na API.

- **Padronização**: O Swagger segue o padrão OpenAPI, o que facilita a integração com outras ferramentas e serviços que
  suportam esse padrão.

Explorar a documentação da API com Swagger é uma excelente maneira de entender rapidamente as capacidades do projeto
Vacancy e como interagir com ele.
