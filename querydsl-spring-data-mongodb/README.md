querydsl-spring-data-mongodb
===============
Aplicação Java Web demonstra como trabalhar com o QueryDSL, uma tecnologia para geração de consultas através de uma API alto nível. O foco desse projeto é demonstrar como trabalhar com o QueryDSL e Spring Data com o MongoDB, uma tecnologia de persistência NoSQL. Aplicação bem simples, formada por uma página que permite que usuário realize consultas flexíveis fazendo composição com diferentes filtros, ordenação e paginação.

Além do QueryDSL, nesse projeto utilizo o Spring MVC, Spring Data para MongoDB, JQuery e Foundation (front-end). O build e ciclo de vida do projeto são gerenciados pelo Maven ou Gradle. Outra tecnologia incorporada é o Spring Boot, para facilitar a definição de dependências e para disponibilizar um web container (Tomcat) embutido para executar a aplicação. Durante a inicialização da aplicação o banco de dados é re-criado com dados default (veja o arquivo src/main/java/br/com/yaw/querydsl/boot/Application.java).

* Saiba mais sobre o QueryDSL nessa url: http://www.querydsl.com/
* Mais detalhes sobre o projeto Spring Data: http://projects.spring.io/spring-data/
* Sobre o Spring Boot, mais informações estam disponíveis na url: http://projects.spring.io/spring-boot/

Esse é um projeto aberto e livre, para fins de estudo.

Detalhes da implementação
-------
Tecnologias utilizadas na implementação:

* QueryDSL (Morphia): na camada de persistência, geração das consultas via código Java;
* Spring Data MongoDB: módulo de otimização de persistência do Spring para MongoDB;
* MongoDB: banco de dados NoSQL baseado em documentos (JSON / BSON);
* Spring MVC: framework MVC do back-end;
* Foundation: framework CSS;
* JQuery: framework JavaScript;
* Spring Boot: template de dependências e web container embutido;

Pré-requisitos
-------
* JDK - versão 1.8 do Java, ou mais recente;
* Qualquer IDE Java com suporte ao Maven;
* Maven ou Gradle - para build e dependências.
* Instale o mongodb.

Após baixar os fontes, para executar a aplicação execute o comando (terminal / prompt):
* Maven: $ mvn clean package spring-boot:run
* Gradle: $ gradle bootRun

