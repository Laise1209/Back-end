# 🔐 Exemplo: API REST para Cadastro e Autenticação de Usuários

Neste exercício, você vai criar uma **API REST simples** para simular um sistema de **cadastro e autenticação de
usuários**.

---

## 🧠 Objetivo

- Criar endpoints para:
    - Cadastrar usuários
    - Listar todos os usuários
    - Fazer login/autenticação

> 🧪 **Você não precisa usar banco de dados neste projeto!**
>
> 👉 Pode fazer tudo **na própria controller**, utilizando uma **lista em memória** (`List<Usuario>`) para armazenar os
> dados enquanto a aplicação estiver rodando.

---

## 🚨 Segurança: Atenção com a Senha!

> **A senha NUNCA deve ser exibida nas respostas da API!**
> - Ela deve ser informada apenas no momento do cadastro e login.
> - Nunca inclua a senha no retorno do `GET /usuarios` ou de qualquer outro endpoint.

---

## 🛠️ Endpoints da API

### ✅ `GET /usuarios` — Listar usuários

Retorna uma lista de todos os usuários cadastrados (exceto a senha).

#### Exemplo de resposta:

```json
[
  {
    "id": "ae460009-b52b-4c4a-bce0-722dc8c996ad",
    "nome": "nome",
    "email": "email@email.com",
    "autenticado": false
  }
]
```

---

### ➕ `POST /usuarios` — Cadastrar novo usuário

Recebe os dados de um novo usuário e o adiciona à lista.

#### Exemplo de requisição:

```json
{
  "nome": "nome",
  "email": "email@email.com",
  "senha": "spring"
}
```

#### Validações:

- **Nome**: não pode ser nulo, vazio ou conter apenas espaços.
- **Email**: deve ser um e-mail válido e não pode ser nulo.
- **Senha**: não pode ser nula, vazia ou conter apenas espaços.

#### Exemplo de resposta (sem senha!):

```json
{
  "id": "ae460009-b52b-4c4a-bce0-722dc8c996ad",
  "nome": "nome",
  "email": "email@email.com",
  "autenticado": false
}
```

---

### 🔐 `POST /usuarios/login` — Fazer login

Autentica um usuário com base no e-mail e senha fornecidos.

#### Exemplo de requisição:

```json
{
  "usuario": "john@doe.com",
  "senha": "churrasco"
}
```

#### Validações:

- **Usuário**: não pode ser nulo, vazio ou conter apenas espaços.
- **Senha**: não pode ser nula, vazia ou conter apenas espaços.

#### Respostas possíveis:

- ✅ Quando os dados estiverem corretos:
  ```
  Usuário autenticado com sucesso!
  ```
- ❌ Quando o e-mail ou senha estiverem incorretos:
  ```
  Usuário e/ou senha inválidos!
  ```

---

## 📎 Observações Finais

- Use uma **lista estática ou de instância** para simular o banco de dados.
- Gere um `UUID` para representar o `id` de cada usuário. Utilize a classe `UUID` do Java com o método `randomUUID()`.
- Não se preocupe com frameworks de segurança como Spring Security neste momento — foco na lógica de autenticação básica
  e no controle das informações retornadas.
