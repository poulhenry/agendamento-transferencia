# Sistema de Agendamento de Transferências

Aplicação desenvolvida como teste técnico para gerenciamento de agendamentos de transferências financeiras.

<video src="./docs/Screencast From 2026-06-21 19-23-26.mp4" controls></video

## Tecnologias Utilizadas

### Backend

- Java 11
- Spring Boot 2.7.x
- Spring Data JPA
- H2 Database
- Maven

### Frontend

- Vue.js 3
- Vite
- Axios

## Arquitetura

O projeto foi organizado em dois módulos:

```text
agendamento-transferencias/
│
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── ...
│
├── frontend/
│   ├── agendamento/
│   ├── package.json
│   └── ...
│
└── README.md
```

### Backend

O backend foi desenvolvido utilizando Spring Boot e segue uma arquitetura em camadas:

- controller
- service
- repository
- DTO
- entity

A regra de cálculo de taxas foi isolada na camada de serviço para facilitar manutenção. Foi aplicado o design pattern strategy e factory para separar, organizar e melhorar a manutenibilidade de cada range de datas referente a regra de negocio.

### Frontend

O frontend foi desenvolvido em Vue.js e possui duas funcionalidades principais:

- Cadastro de transferências
- Consulta dos agendamentos realizados

## Regras de Negócio

O cálculo da taxa é realizado de acordo com a quantidade de dias entre a data de agendamento e a data da transferência.

| Dias    | Taxa Fixa | Taxa Percentual |
| ------- | --------- | --------------- |
| 0       | R$ 3,00   | 2,5%            |
| 1 a 10  | R$ 12,00  | 0%              |
| 11 a 20 | R$ 0,00   | 8,2%            |
| 21 a 30 | R$ 0,00   | 6,9%            |
| 31 a 40 | R$ 0,00   | 4,7%            |
| 41 a 50 | R$ 0,00   | 1,7%            |

Caso não exista uma taxa aplicável para a data informada, a transferência não é permitida.

## Como Executar o Projeto

### Pré-requisitos

- Java 11
- Node.js 18+
- NPM

---

## Executando o Backend

Acesse a pasta:

```bash
cd backend
```

Execute a aplicação:

```bash
./mvnw spring-boot:run
```

Windows:

```cmd
mvnw.cmd spring-boot:run
```

A API será iniciada em:

```text
http://localhost:8080
```

### Console H2

Disponível em:

```text
http://localhost:8080/h2-console
```

Configuração:

```text
JDBC URL: jdbc:h2:mem:schedule
User Name: admin
Password: 123
```

---

## Executando o Frontend

Acesse a pasta:

```bash
cd frontend/agendamento
```

Instale as dependências:

```bash
npm install
```

Execute o projeto:

```bash
npm run dev
```

A aplicação será iniciada em:

```text
http://localhost:5173
```

## Endpoints Disponíveis

### Criar Transferência

```http
POST /agendamento
```

### Listar Transferências

```http
GET /agendamento
```

## Decisões Arquiteturais

- Utilização do banco H2 em memória para simplificar a execução do projeto.
- Separação entre frontend e backend em módulos distintos.
- Utilização de DTOs para comunicação entre API e cliente.
- Centralização das regras de negócio na camada de serviço.
- CORS configurado para permitir a comunicação entre frontend e backend durante o ambiente de desenvolvimento.
- Persistência realizada através do Spring Data JPA.
