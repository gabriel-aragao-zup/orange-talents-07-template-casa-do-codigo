# Lista de Decisões tomadas nessa feature

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


