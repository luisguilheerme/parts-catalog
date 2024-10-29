# Catálogo Online de Peças Automotivas.

Um catálogo feito para facilitar na busca de componentes de motores de partida e alternadores.


## Tecnologias Utilizadas

- Spring Boot
- H2 Database
- Java
- Swagger
- 
## Configuração do Ambiente

Certifique-se de ter o Java e o Maven instalados em sua máquina antes de prosseguir.

## Configuração do Banco de Dados

A aplicação está configurada para usar o banco de dados H2 em memória por padrão. Você pode ajustar as configurações do banco de dados no arquivo `application.properties`.

## Como Usar

### Construindo o Projeto

Para construir o projeto, execute o seguinte comando:

```bash
mvn clean install
```

### Executando a Aplicação

Para executar a aplicação, use o comando:

```bash
mvn spring-boot:run
```

## Documentação da API (Swagger)

Você pode acessar a documentação da API utilizando o Swagger. Após iniciar a aplicação, acesse o seguinte URL em seu navegador:

http://localhost:8080/swagger-ui.html


```

Um relatório de cobertura de testes será gerado na pasta target/site/jacoco. Abra o arquivo index.html em seu navegador para visualizar os resultados.



