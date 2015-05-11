querydsl-jpa
===============
Aplicação Java Web demonstra como trabalhar com o QueryDSL, uma tecnologia para geração de consultas através de uma API alto nível. O foco desse projeto é demonstrar como trabalhar com o QueryDSL e JPA / Hibernate com banco de dados HSQLDB (em memória).  Aplicação bem simples, formada por uma página que permite que usuário realize consultas flexíveis fazendo composição com diferentes filtros, ordenação e paginação.

Além do QueryDSL, nesse projeto utilizo o Spring MVC, Spring Transaction, JQuery e Foundation (front-end). O build e ciclo de vida do projeto são gerenciados pelo Maven ou Gradle. Outra tecnologia incorporada é o Spring Boot, para facilitar a definição de dependências e para disponibilizar um web container (Tomcat) embutido para executar a aplicação. Durante a inicialização da aplicação o banco de dados é re-criado com dados default (veja o arquivo src/main/resources/data.sql).

* Saiba mais sobre o QueryDSL nessa url: http://www.querydsl.com/
* Sobre o Spring Boot, mais informações estam disponíveis na url: http://projects.spring.io/spring-boot/

Trata-se de um projeto aberto e livre, para fins de estudo.

Detalhes da implementação
-------
Tecnologias utilizadas na implementação:

* QueryDSL: na camada de persistência, geração das consultas via código Java;
* JPA/Hibernate: tecnologia base da camada de persistência (ORM);
* HSQLDB: banco de dados Java em memória;
* Spring MVC: framework MVC do back-end;
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

