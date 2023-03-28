# Pet <!-- Listagem dos endpoints -->
## Endpoints 
- [Cadastro do animal](#cadastro-de-pet)
- [Detalhes do animal que está sendo cadastrado](#detalhes-pet)
- [Detalhar despesas do pet](#detalhar-despesa) 
- Listar gastos (Extrato)
- Editar despesa 

---
### Cadastro de Pet 
<!-- Endereço do recurso -->
`POST` pet/api/v1/despesa

<!-- Colocar a versão é importante para compatibilidade  --> 
**Exemplo de Entrada** 
```js
{
    "Genero": 'Fêmea',
    "Raça": 'Labrador',
    "animal_id": 1,
    "nome": 'Kira',
    "dt nascimento": '2022-12-24',
    "peso": '2,3 kgs',
    "idade": '3 meses'
}
```

**Campos da Requisição**
| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-----------:|-------|-----------|

|Genero|sim|texo|Definir se é Fêmea ou Macho
|Raça|sim|texto| deverá escolher a raça do animal
|animal_id|sim|int| O id do animal, deve ser uma categoria previamente cadastrada
|nome|sim|texto|deve escerever o nome do animal
|peso|sim|float|definir o peso do animal
|idade |sim|decimal|a idade do animal, deve ser maior que zero
||||
|dt nascimento|sim|data| a data do nascimento do animal
|descricao|não|texto| uma descrição da despesa com no máximo 255 caracteres

**Códigos da Resposta**

|código|cadastro
|-|-
201 | o animal foi cadastrado com sucesso
400 | os dados enviados são inválidos

---

### Detalhar Animal

`GET` pet/api/v1/cadastro/{id}

**Exemplo de Resposta** 
```js
{
    "Raca": 'Labrador',
    "Genero": 'Fêmea',
    "animal": {
        "id": 1,
        "nome": "Kira"
        "peso": "2,3 kgs"
        "idade": "3 meses"
    },
    "dt nascimento": '2022-12-24',
    
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | os dados do animal não foram retornados
404 | não existe animal com o ID informado
