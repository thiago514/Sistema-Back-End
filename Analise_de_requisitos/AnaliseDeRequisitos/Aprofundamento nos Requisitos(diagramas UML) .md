# Aprofundamento nos Requisitos(diagramas UML)

Para desenvolver o Software atendendo todas as demandas do usuário resolvi fazer a analise dos requisitos fazendo os diagramas de caso de uso e os diagramas de classe além da descrição de cenários servindo como documentação e orientação na produção do software

![Untitled](Aprofundamento%20nos%20Requisitos(diagramas%20UML)%20314f3c361a8f4ec49d394427b2af1baa/Untitled.png)

| Número do Caso de Uso | UC001                                                                                                                                                                                                                |
| --------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Nome do Caso de Uso   | Cadastrar Pessoa                                                                                                                                                                                                     |
| Ator(es)              | Usuário                                                                                                                                                                                                              |
| Descrição             | Este caso de uso tem por objetivo receber os dados para fazer o cadastro de uma pessoa                                                                                                                               |
| Pré-condições         | Nenhuma                                                                                                                                                                                                              |
| Regras de Negócio     | 1 O sistema recebe via protocolo http um JSON contendo os dados para o cadastro da pessoa;      2 O sistema verifica se as informações repassadas no JSON são validas(EXC001); 3 O sistema insere no Banco de dados. |
| Exceções              | EXC001 - Dados Inválidos                                                                                                                                                                                             |
| Includes              | Não há                                                                                                                                                                                                               |
| Extends               | Não há                                                                                                                                                                                                               |

| Número do Caso de Uso | UC002                                                                                       |
| --------------------- | ------------------------------------------------------------------------------------------- |
| Nome do Caso de Uso   | Editar Pessoa                                                                               |
| Ator(es)              | Usuário                                                                                     |
| Descrição             | Este caso de uso tem por objetivo alterar as informações de uma pessoa                      |
| Pré-condições         | A Pessoa deve estar cadastrada no Sistema                                                   |
| Regras de Negócio     | 1. O sistema recebe via protocolo http um JSON contendo o id e os dados para a modificação; 1. Busca pelo id a pessoa no Banco de dados(EXC002);2. O sistema altera os dados e salva no Banco de Dados; |
| Exceções | EXC002 - ID não encontrado |
| Includes | UC007 - verifica se a pessoa existe |
| Extends | Não há |

| Número do Caso de Uso | UC003                                                                     |
| --------------------- | ------------------------------------------------------------------------- |
| Nome do Caso de Uso   | Consultar dados Pessoa                                                    |
| Ator(es)              | Usuário                                                                   |
| Descrição             | Este caso de uso tem por objetivo obter as informações de uma pessoa      |
| Pré-condições         | A Pessoa deve estar cadastrada no Sistema                                 |
| Regras de Negócio     | 1. O sistema recebe uma requisição via protocolo http com o id da pessoa; 2. Busca pelo id a pessoa no Banco de dados(EXC002); 3. O sistema retorna um JSON contendo todos os dados da pessoa. |
| Exceções | EXC002 - ID não encontrado |
| Includes | UC007 - verifica se a pessoa existe |
| extends | Não há |

| Número do Caso de Uso | UC004                                                                     |
| --------------------- | ------------------------------------------------------------------------- |
| Nome do Caso de Uso   | Listar Pessoas                                                            |
| Ator(es)              | Usuário                                                                   |
| Descrição             | Este caso de uso tem por objetivo listar os dados das pessoas cadastradas |
| Pré-condições         | Nenhuma                                                                   |
| Regras de Negócio     | 1. O sistema recebe uma requisição via protocolo http;                    2. O sistema busca no banco de dados todas as pessoas cadastradas;3.O sistema retorna em forma de JSON todas as pessoas cadastradas |
| Exceções | Não há |
| Includes | Não há |
| extends | Não há. |

| Número do Caso de Uso | UC005                                                                                                                                         |
| --------------------- | --------------------------------------------------------------------------------------------------------------------------------------------- |
| Nome do Caso de Uso   | Criar Endereço para Pessoa                                                                                                                    |
| Ator(es)              | Usuário                                                                                                                                       |
| Descrição             | Este caso de uso tem por objetivo fazer o cadastro de endereço para uma pessoa                                                                |
| Pré-condições         | A Pessoa deve estar cadastrada no Sistema                                                                                                     |
| Regras de Negócio     | 1. O sistema recebe uma requisição via protocolo http com o id da pessoa que deseja cadastrar um endereço e um JSON com o endereço da pessoa; 2. Busca pelo id a pessoa no Banco de dados(EXC002);3. O sistema cadastra o endereço da pessoa;
 |
| Exceções | EXC002 - ID não encontrado |
| Includes | UC007 - verifica se a pessoa existe |
| extends | Não há |

| Número do Caso de Uso | UC006                                                                     |
| --------------------- | ------------------------------------------------------------------------- |
| Nome do Caso de Uso   | Listar Endereços da pessoa                                                |
| Ator(es)              | Usuário                                                                   |
| Descrição             | Este caso de uso tem por objetivo listar todos os endereços de uma pessoa |
| Pré-condições         | A Pessoa deve estar cadastrada no Sistema                                 |
| Regras de Negócio     | 1. O sistema recebe uma requisição via protocolo http com o id da pessoa; 2. Busca pelo id a pessoa no Banco de dados(EXC002);3.O sistema retorna em forma de JSON todos os endereços da pessoa. |
| Exceções | EXC002 - ID não encontrado |
| Includes | UC007 - verifica se a pessoa existe |
| extends | Não há |

| Número do Caso de Uso | UC007                                                                                                      |
| --------------------- | ---------------------------------------------------------------------------------------------------------- |
| Nome do Caso de Uso   | Verificar se a pessoa existe                                                                               |
| Ator(es)              | Usuário                                                                                                    |
| Descrição             | Este caso de uso tem por objetivo verifica se existe algum registro no Banco de dados com um id especifico |
| Pré-condições         | Nenhuma                                                                                                    |
| Regras de Negócio     | 1. O sistema recebe um id de pessoa;                                                                       2. O sistema busca no banco de dados o id recebido;  2.1 Caso não seja encontrado nenhum id uma exceção é lançada(EXC002) |
| Exceções | EXC002 - ID não encontrado |
| Includes | Não há |
| extends | Não há. |

| Número do Caso de Uso | UC008                                                                                                      |
| --------------------- | ---------------------------------------------------------------------------------------------------------- |
| Nome do Caso de Uso   | Verificar se o endereco existe                                                                             |
| Ator(es)              | Usuário                                                                                                    |
| Descrição             | Este caso de uso tem por objetivo verifica se existe algum registro no Banco de dados com um id especifico |
| Pré-condições         | Nenhuma                                                                                                    |
| Regras de Negócio     | 1. O sistema recebe um id de endereco;                                                                     2. O sistema busca no banco de dados o id recebido;  2.1 Caso não seja encontrado nenhum id uma exceção é lançada(EXC002) |
| Exceções | EXC002 - ID não encontrado |
| Includes | Não há |
| extends | Não há. |

| Número do Caso de Uso | UC009                                                  |
| --------------------- | ------------------------------------------------------ |
| Nome do Caso de Uso   | Deletar pessoa                                         |
| Ator(es)              | Usuário                                                |
| Descrição             | Este caso de uso tem por objetivo deletar uma pessoa   |
| Pré-condições         | Existir uma pessoa com o referente id cadastrado no BD |
| Regras de Negócio     | 1. O sistema recebe um id de endereco;                 2. O sistema busca no banco de dados o id recebido;2.1 Caso não seja encontrado nenhum id uma exceção é lançada(EXC002)3. O sistema deleta do BD os dados da pessoa |
| Exceções | EXC002 - ID não encontrado |
| Includes | UC007 - Verifica se pessoa existe |
| extends | Não há. |

| Número do Caso de Uso | UC010                                                   |
| --------------------- | ------------------------------------------------------- |
| Nome do Caso de Uso   | Editar Endereço                                         |
| Ator(es)              | Usuário                                                 |
| Descrição             | Este caso de uso tem por objetivo editar um endereço    |
| Pré-condições         | Existir um endereço com o referente id cadastrado no BD |
| Regras de Negócio     | 1. O sistema recebe um id de endereco;                  2. O sistema busca no banco de dados o id recebido;2.1 Caso não seja encontrado nenhum id uma exceção é lançada(EXC002)3. O sistema altera as informações do endereço no BD |
| Exceções | EXC002 - ID não encontrado |
| Includes | UC008 - Verifica se o Endereço Existe |
| extends | Não há. |

| Número do Caso de Uso | UC011                                                   |
| --------------------- | ------------------------------------------------------- |
| Nome do Caso de Uso   | Deletar endereço                                        |
| Ator(es)              | Usuário                                                 |
| Descrição             | Este caso de uso tem por objetivo deletar um endereço   |
| Pré-condições         | Existir um endereço com o referente id cadastrado no BD |
| Regras de Negócio     | 1. O sistema recebe um id de endereço;                  2. O sistema busca no banco de dados o id recebido2.1 Caso não seja encontrado nenhum id uma exceção é lançada(EXC002)3. Deletar o Endereço |
| Exceções | EXC002 - ID não encontrado |
| Includes | UC008 - Verifica se o Endereço Existe |
| extends | Não há. |

![Untitled](Aprofundamento%20nos%20Requisitos(diagramas%20UML)%20314f3c361a8f4ec49d394427b2af1baa/Untitled%201.png)