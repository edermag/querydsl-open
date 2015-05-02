querydsl-jpa
===============
Aplicação Java Web demonstra como trabalhar com o QueryDSL, uma tecnologia para geração de consultas através de uma API alto nível. O foco desse projeto é demonstrar como trabalhar com o QueryDSL e JPA / Hibernate com banco de dados HSQLDB (em memória). Aplicação apresenta uma página para consultar Mercadoria, durante a inicialização da aplicação é executado um script (veja o arquivo src/main/resources/data.sql) com os dados default.

Além disso nesse projeto utilizo o Spring MVC, Spring Transaction, JQuery e Foundation (front-end). O build e ciclo de vida do projeto são gerenciados pelo Maven ou Gradle. Na verdade utilizo o Spring Boot para facilitar as dependência e para contar um web container (Tomcat) embutido.

Saiba mais sobre o QueryDSL nessa url: http://www.querydsl.com/
Sobre o Spring Boot, mais informações estam disponíveis na url: http://projects.spring.io/spring-boot/

Trata-se de um projeto aberto e livre, para fins de estudo.

Na pasta comandos-mongo, você encontra exemplos de comandos para manipular dados no MongoDB via shell:
* Insert, Update, Delete, Query e Aggregation.

Detalhes da implementação
-------
Tecnologias utilizadas na implementação:

* QueryDSL: na camada de persistência, geração das consultas via código Java;
* JPA/Hibernate: tecnologia base da camada de persistência (ORM);
* HSQLDB: banco de dados Java em memória;
* Foundation: framework css;
* JQuery: framework JavaScript;
* Spring Boot: template de dependências e web container embutido;

Pré-requisitos
-------
* JDK - versão 1.8 do Java, ou mais recente;
* Qualquer IDE Java com suporte ao Maven;
* Maven ou Gradle - para build e dependências.

Após baixar os fontes, para executar a aplicação execute o comando (terminal / prompt):
* Maven: $ mvn clean package spring-boot:run
* Gradle: $ gradle bootRun

