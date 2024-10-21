# Desafio Validacao Seguranca
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

# Sobre o projeto

Este repositório é uma atividade avaliativa do curso Spring Boot Expert da DevSuperior, desenvolvida com foco no Test-Driven Development (TDD) de uma API Rest em Java e Spring Boot. As competências avaliadas incluem implementação de segurança com Spring Security e OAuth2, controle de acesso por rotas e perfis de usuário, além de validação de dados utilizando Bean Validation.

### Tecnologias Utilizadas

-  *Back end*: Spring Boot, com foco no desenvolvimento guiado por testes (TDD), Spring Security e OAuth2 para controle de acesso por rotas e perfis de usuário, além de validação de dados com Bean Validation.
  
Durante o desenvolvimento, aprofundei meus conhecimentos em TDD, segurança com OAuth2 e validação de dados, aplicando boas práticas para criar uma aplicação sólida e segura.

## Modelo conceitual
![Modelo Conceitual](/assetsReadme/diagrama.png)

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- TDD

# Rotas da API

### /cities
- **`POST /cities`**  
  - **Descrição:** Insere uma nova cidade.
  - **Acesso:** 
    - Não autenticado: Retorna status 401 (Unauthorized).
    - Usuário com perfil de cliente: Retorna status 403 (Forbidden).
    - Usuário com perfil de administrador e dados corretos: Retorna status 201 (Created) e o objeto da cidade criada.
    - Usuário com perfil de administrador e nome em branco: Retorna status 422 (Unprocessable Entity) com mensagens de validação.
  - **Exemplo de Request Body:**
    ```json
    {
      "name": "Recife"
    }
    ```

- **`GET /cities`**  
  - **Descrição:** Retorna a lista de todas as cidades, ordenadas por nome.
  - **Acesso:** Aberto (sem autenticação).
  - **Resposta de sucesso:** Status 200 (OK) com uma lista de cidades.
  - **Exemplo de Resposta:**
    ```json
    [
      {
        "id": 1,
        "name": "Belo Horizonte"
      },
      {
        "id": 2,
        "name": "Belém"
      },
      {
        "id": 3,
        "name": "Brasília"
      }
    ]
    ```
### /events

- **`POST /events`**  
  - **Descrição:** Insere um novo evento.
  - **Acesso:** 
    - Não autenticado: Retorna status 401 (Unauthorized).
    - Usuário com perfil de cliente e dados corretos: Retorna status 201 (Created) e o objeto do evento criado.
    - Usuário com perfil de administrador e dados corretos: Retorna status 201 (Created) e o objeto do evento criado.
    - Usuário com perfil de administrador e nome em branco: Retorna status 422 (Unprocessable Entity) com mensagens de validação.
    - Usuário com perfil de administrador e data do evento no passado: Retorna status 422 (Unprocessable Entity) com mensagens de validação.
    - Usuário com perfil de administrador e cidade nula: Retorna status 422 (Unprocessable Entity) com mensagens de validação.
  - **Exemplo de Request Body:**
    ```json
    {
      "name": "Expo XP",
      "date": "2024-11-01",
      "url": "https://expoxp.com.br",
      "cityId": 1
    }
    ```

- **`GET /events`**  
  - **Descrição:** Retorna uma lista paginada de eventos.
  - **Acesso:** Aberto (sem autenticação).
  - **Resposta de sucesso:** Status 200 (OK) com uma lista de eventos paginada.
  - **Exemplo de Resposta:**
    ```json
    {
      "content": [
        { "id": 1, "name": "Expo XP", "date": "2024-11-01", "url": "https://expoxp.com.br", "cityId": 1 },
        { "id": 2, "name": "Tech Conference", "date": "2024-12-15", "url": "https://techconf.com", "cityId": 2 }
      ],
      "totalPages": 1,
      "totalElements": 2
    }
    ```

# Como executar o projeto

## Back end
Pré-requisitos: Java 21

```bash
# clonar repositório
git clone https://github.com/Ital023/DSCommerce.git

# executar o projeto
./mvnw spring-boot:run
```

## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/Ital023" title="Github do Ítalo Miranda">
        <img src="https://avatars.githubusercontent.com/u/113559117?v=4" width="100px;" alt="Foto do Ítalo Miranda no GitHub"/><br>
        <sub>
          <b>Ítalo Miranda</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
