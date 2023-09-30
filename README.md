# RhLog

<h1>Projeto: API Controle de entregas</h1>
<hr>
<h3>Descrição do desafio</h3>
Projeto elaborado para fazer o controle de entregas desde o cadastro das entregas e clientes, acompanhando o status das entregas e as ocorrências das mesmas.
<hr>
<h3>Tecnologias Utilizadas</h3>

Para iniciar este projeto, foi utilizado o <a href="https://start.spring.io/">spring initializr</a> utilizando as opções:
<ul>
    <li>IDE IntelliJ</li>
    <li>Projeto: Maven </li>
    <li>Linguagem: Java 17</li>
    <li>Spring Boot: 3.0.1</li>
    <li>ModelMapper</li>
    <li>Dependências: Spring Web, Spring Data JPA, Lombok, H2 Database e SpringDoc</li>

Dependência adicionada manualmente no pom.xml: <a href="https://springdoc.org/v2/"> springdoc-openapi v2.1.0.</a>
</ul>
<hr>
<h3>Funcionalidades</h3>

**Registro de Entrega:** O cliente pode registar uma entrega fornecendo os dados do destinatário é o valor da taxa de entrega. 

**Controle da entrega:** O usuário pode verificar o status da entrega junto com suas ocorrências.

**Validação de campos em branco junto com o email existente:** O sistema válida automaticamente na hora de cadastrar o cliente se o email já existe na base de dados e verifica se existe algum campo em branco tanto na hora do registro do cliente como na entrega.

<hr>

### Utilize para acessar a interface com os endpoints no Swagger:
```
localhost:8080/swagger-ui.html
```
### Endpoints
###### Post - Cliente
```
body
{
  "nome": "Reynaldo",
  "email": "rey1@email.com",
  "telefone": "869888888888"
}
```
###### Response
```
json
{
    "id": 2,
    "nome": "Reynaldo",
    "email": "rey1@email.com",
    "telefone": "869888888888"
}
```

###### Post - Entrega
```
body
{
    "cliente":{
        "id":1
    },
    "destinatario":{
        "nome":"Maria João",
        "logradouro":"Rua XXV",
        "numero":"50",
        "complemento":"Altos",
        "bairro":"Lugar Nenhum"
    },
    "taxa": 20.00
}
```
###### Response
```
json
{
    "id": 1,
    "cliente": {
        "id": 1,
        "nome": "Reynaldo"
    },
    "destinatario": {
        "nome": "Maria João",
        "logradouro": "Rua XXV",
        "numero": "50",
        "complemento": "Altos",
        "bairro": "Lugar Nenhum"
    },
    "taxa": 20,
    "status": "PENDENTE",
    "dataPedido": "2023-09-05T18:14:30.2798047-03:00",
    "dataFinalizacao": null
}
```


#### Utilize o git para clonar o repositório:
```
git clone https://github.com/reynaldo86/RhLog.git
```

<hr>
<h2>Links Úteis</h2>
<ul>
    <li><a href="https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.6.1&packaging=jar&jvmVersion=11&groupId=me.dio.academia&artifactId=academia-digital&name=academia-digital&description=Tutorial%20API%20RESTful%20modelando%20sistema%20de%20academia%20de%20gin%C3%A1stica&packageName=me.dio.academia.digital&dependencies=web,data-jpa,postgresql,validation,lombok">Spring Initializr</a></li>
    <li><a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories">Spring Data JPA - Reference Documentation</a></li>
    <li><a href="https://github.com/iluwatar/java-design-patterns">Java-design-patterns</a></li>
    <li><a href="https://springdoc.org/">SpringDoc</a></li>

</ul>

