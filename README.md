# API REST para Conversão de Moedas

API REST desenvolvida em Java com Spring Boot para conversão de moedas em tempo real, 
consumindo a [Frankfurter API](https://frankfurter.dev) como fonte de cotações.

## 🚀 Deploy

- **API:** https://cotacao-moedas-java-production.up.railway.app
- **Frontend:** [link do seu frontend aqui]

## 🛠️ Tecnologias utilizadas

- Java 21
- Spring Boot
- RestTemplate
- Frankfurter API
- Railway (deploy)

## 📌 Endpoints

### Converter moeda

```
GET /cotacao/convert?from={moeda-base}&to={moeda-final}&amount={valor}
```
| Parâmetro | Tipo | Descrição |
|---|---|---|
| from | String | Moeda de origem. Ex: USD |
| to | String | Moeda de destino. Ex: BRL |
| amount | BigDecimal | Valor a converter (deve ser maior que 0) |

**Exemplo de resposta:**
```json
{
  "from": "USD",
  "to": "BRL",
  "amount": 500,
  "rate": 5.75,
  "result": 2875.00
}
```

### Listar moedas disponíveis

```
GET /cotacao/currencies
```
Retorna todas as moedas disponíveis para conversão.

## ⚙️ Como rodar localmente

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/cotacao-moedas

# Entre na pasta
cd cotacao-moedas

# Rode com Maven
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.
