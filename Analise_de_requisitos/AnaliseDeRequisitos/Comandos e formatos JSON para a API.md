# Comandos e formatos JSON para a API

Aqui está alguns exemplos sobre os formatos de JSON para testar e utliizar a API

- POST
    - Adicionar uma pessoa(**/pessoa**)
        
        Estrutura do JSON
        
        ```json
        {
        	"nome" : "Gabriel",
        	"data_de_nascimento" : "12/12/2008"
        }
        ```
        
    - Adicionar um endereco(**/endereco**)
        
        Estrutura do JSON
        
        ```json
        {
        	"logradouro" : "Frei menandro kamps",
        	"cep" : "89460-096",
        	"numero" : "1466",
        	"cidade" : "Canoinhas",
        	"principal" : "true",
        	"pessoa_id" : "1"
        }
        ```
        
- GET
    - Receber todas as pessoas(**/pessoa**)
        - Para receber apenas os dados de uma pessoa basta adicionar o id no final do endereço(**/pessoa/ID**)
    
    Estrutura do JSON
    
    ```json
    [
    	{
    		"pessoa_id": 1,
    		"nome": "Gabriel",
    		"data_de_nascimento": "12/12/2008",
    		"enderecos": [
    			{
    				"endereco_id": 1,
    				"logradouro": "Frei menandro kamps",
    				"cep": "89460-096",
    				"numero": 1466,
    				"cidade": "Canoinhas",
    				"principal": false,
    				"pessoa_id": 1
    			},
    			{
    				"endereco_id": 2,
    				"logradouro": "Frei menandro kamps",
    				"cep": "89460-096",
    				"numero": 1476,
    				"cidade": "Canoinhas",
    				"principal": false,
    				"pessoa_id": 1
    			}
    		]
    	},
    	{
    		"pessoa_id": 2,
    		"nome": "Gabriel",
    		"data_de_nascimento": "12/12/2008",
    		"enderecos": []
    	}
    ]
    ```
    
    - Receber todas os endereços(**/endereco**)
        - Para receber apenas os dados de um endereço basta adicionar o id no final do endereço(**/endereco/ID**)
        - Para receber apenas os endereços de uma pessoa em especifico basta colocar o id da pessoa dessa forma(**/endereco/pessoa/ID**)
    
    Estrutura do JSON
    
    ```json
    [
    	{
    		"endereco_id": 1,
    		"logradouro": "Frei menandro kamps",
    		"cep": "89460-096",
    		"numero": 1445,
    		"cidade": "Canoinhas",
    		"principal": false,
    		"pessoa_id": 1
    	},
    	{
    		"endereco_id": 2,
    		"logradouro": "Frei menandro kamps",
    		"cep": "89460-096",
    		"numero": 1455,
    		"cidade": "Canoinhas",
    		"principal": false,
    		"pessoa_id": 1
    	}
    ]
    ```
    
- PUT
    - Alterar uma pessoa(**/pessoa**)
    
    Estrutura JSON
    
    ```json
    {
    	"pessoa_id" : 1,
    	"nome" : "Pedro"
    }
    ```
    
    - Alterar um endereço (**/endereco**)
    
    Estrutura JSON
    
    ```json
    {
    	"endereco_id" : 2,
    	"logradouro" : "Frei menandro kamps",
    	"cep" : "89460-096",
    	"numero" : "1466",
    	"cidade" : "Canoinhas",
    	"principal" : "false",
    	"pessoa_id" : "2"
    }
    ```
    
- DELETE
    - Deletar uma pessoa (**/pessoa/ID**)
    - Deletar um Endereço (**/endereco/ID**)