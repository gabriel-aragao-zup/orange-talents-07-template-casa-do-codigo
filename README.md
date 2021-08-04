# Por favor faça um Fork desse projeto!

## Está em dúvida de como fazer um Fork? Não tem problema! [Aqui tem uma explicação do que entendemos que você deve considerar!](https://docs.github.com/en/github/getting-started-with-github/fork-a-repo)

## Lista de decisões tomadas ao longo do desenvolvimento:

Com a probabilidade de essa lista crescer de  maneira demasiada decidi adicionar um readme para cada package com decisões referentes a construção da respectiva feature.

### 1 - Banco de dados H2

Como não houve inicialmente restrições e o banco H2 facilita o desenvolvimento por sua fácil utilização e configuração.

### 2 - Package by feature

Pela explicação dada pelo Alberto no material de apoio fiquei convencido que: o package by feature deixa mais claro cada funcionalidade existente no sistema e pode ser mais fácil se adaptar ou dar manutenção em um código organizado dessa maneira.

#### 2.1 Nomeclatura LayerEntity

Decidi nomear as classes e interfaces dentro do pacote com o nome do que seria a camada aparecendo primeiro (Ex: RepositoryAutor, ControllerAutor...) pra facilitar encontrar os arquivos referentes a cada camada dentro do pacote, ja que decidi usar o PackageByFeature

### 3 - Uso do JPARepository

Decidi usar o Repository em primeiro lugar por trazer facilidade e simplicidade para implementação comparando com o EntityManager, e decidi Utilizar o JpaRepository por ter métodos adicionais em relação ao CRUDRepository eo PagingAndSortingRepository. (Talvez o PagingAndSorting tenha tudo que será necessário para o sistema agora e no futuro. Talvez não. Vou ficar com o JpaRepository em um primeiro momento por ter o costume de utilizar bazucas para matar formigas.)

### 4 - Injeção de dependências via construtor

As dependências injetadas via construtor garantem que todas as dependências estarão disponíveis na criação dos objetos e facilita a produção de testes. Por isso decidi utilizar esse padrão. 

### 5 - Validações nas bordas

Decidi deixar as validações apenas nas bordas do sistema que no caso serão os Forms de cada entidade. Acredito que a borda estando bem protegida e o fluxo bem desenhado o sistema esteja bem protegido e o código fique mais limpo. 

### 6 - Uso de Controller Advice

Decidi seguir as recomendações de utilizar o controller advice para tratar as exceções e deixar a aplicação mais segura e clara em relação aos responses de erro. 



# Lista de Decisões tomadas na feature Autor

## Autor

### 1 - Uso do @PrePersist

Decidi utililzar essa anotação para setar o instante de criação do autor antes de persistir a entidade no banco, para evitar que a criação do objeto em algum fluxo futuro do sistema acabe por sobrescrever essa informação no banco.

### 2 - Decidi não utilizar os validadores de DDL

Acredito que essas validações devem estar nas migrations, então coloca-las no código iria poluir a classe com informações que deveriam estar em outro lugar.

## DTOAutor

### 1 - Informações Sensíveis
Decidi criar um DTO para autor por acreditar que as informações de email e data de criação em um primeiro momento possam ser sensíveis e não devam ser apresentadas nos responses por padrão.

# Problemas encontrados no desenvolvimento dessa feature

### 1 - Response entity retornando apenas parte do objeto.

Me deparei com o response entity retornando apenas o Id do meu objeto de resposta.
Pedi ajuda dos colegas e chegamos a conclusão que o problema era a falta de getters na minha classe de resposta.

### 2 - Validações não ocorrendo como esperado.

Fiz a anotação das validações no meu objeto form e utilizei a anotação @Valid no requestbody entretanto as validações não estavam ocorrendo como esperado.
Após uma dúvida sobre dependências de validação percebi que tinha setado como dependência o jakarta validation e não o spring starter validation. Quando substitui a dependência o problema foi resolvido.

### 3 - Limitação no campo String

Precisava de um campo com espaço para 400 caracteres porém mesmo com a anotação @Size(max = 400) ao tentar inserir mais que 255 caracteres ocorria um erro no servidor.
Pelo checkout extendido eu entendi que um campo string é por default traduzido no banco para um Varchar(255), Para sanar esse problema de maneira exepcional decidi usar anotações de DDL para alterar o tamanho da coluna para varchar(400) conforme especificados nos requisitos da feature.

# Lista de Decisões tomadas na feature Categoria

## Categoria

### 1 - Decidi não utilizar os validadores de DDL

Acredito que essas validações devem estar nas migrations, então coloca-las no código iria poluir a classe com informações que deveriam estar em outro lugar.


# Release criar-novo-livro
A partir dessa release decidi mapear todas as decisões no mesmo README pra dar uma ideia melhor de cronologia as decisões tomadas e aos problemas encontrados por conta dessas decisões

## Erros encontrados por decisões tomadas em releases anteriores
Corrigi forms das releases anteriores que continham métodos set, para que eles tivessem apenas construtores ja que entendi um pouco melhor esse conceito de Design by Contract, e sobre a mutabilidade possibilitada pelos setters.

Corrigi os construtores dos models que estavam private para public e deprecated pois recebi um erro dizendo que os construtores padrões desses objetos não existiam quando tentei cadastrar um livro.

## Decisões tomadas nessa release
Decidi criar um DTO para o retorno do cadastro do livro, não exibindo as informações de resumo e sumário, data de publicação, e retornar no lugar do ids de categoria e autor os respectivos nomes.

