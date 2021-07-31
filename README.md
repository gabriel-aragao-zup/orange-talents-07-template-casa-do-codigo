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





