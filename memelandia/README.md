________________________________________
🚀 Projeto Memelândia - Monólito Java com Spring Boot
Este repositório contém a aplicação monolítica original do projeto Memelândia, desenvolvida em Java com Spring Boot. O objetivo principal deste projeto, no contexto do Módulo 15 do curso "Especialista Backend Java", é servir como base para o desmembramento em um conjunto de microsserviços.
A Memelândia é uma aplicação simples para cadastro de usuários, categorias de memes e, claro, memes!
✨ Funcionalidades Principais (Versão Monolítica)
A aplicação monolítica atual oferece as seguintes funcionalidades através de uma API REST:
•	Cadastro de Usuários: Permite registrar novos usuários que podem enviar memes e criar categorias.
o	Campos: nome, email, dataCadastro.
•	Cadastro de Categorias de Memes: Permite criar categorias para organizar os memes.
o	Campos: nome, descricao, dataCadastro, usuario (associada a um usuário que a cadastrou).
•	Cadastro de Memes: Permite registrar novos memes.
o	Campos: nome, descricao, dataCadastro, categoriaMeme (obrigatória), usuario (obrigatório).
o	A URL da imagem ou vídeo do meme é uma simplificação para fins didáticos.
•	Consulta de Dados: Endpoints para listar todos os usuários, categorias e memes cadastrados.
💡 Bônus (Para Implementação Futura)
•	"Meme do Dia": A aplicação pode ser estendida para retornar um meme aleatório da base de dados como "Meme do Dia".
🛠️ Tecnologias Utilizadas
•	Java 11+
•	Spring Boot 2.7.x
•	Spring Data JPA
•	Hibernate
•	H2 Database (banco de dados em memória para desenvolvimento)
•	Maven (gerenciador de dependências)
🚀 Como Executar o Projeto
Siga os passos abaixo para configurar e rodar o projeto em sua máquina.
Pré-requisitos
•	Java Development Kit (JDK): Versão 11 ou 17. Certifique-se de que o JAVA_HOME está configurado corretamente.
•	Apache Maven: Versão 3.6+
•	IDE (Ambiente de Desenvolvimento Integrado): Spring Tool Suite 4 (STS4) ou IntelliJ IDEA são recomendados.
•	Cliente REST: Postman, Insomnia, ou curl para testar a API.
1. Clonando o Repositório (ou Criando o Projeto)
Caso este fosse um repositório Git, o passo seria:
git clone https://github.com/githubebac/backend-java-pro/memelandia # Exemplo de link
cd memelandia
No nosso caso, você já criou o projeto no STS4 e inseriu os arquivos. Certifique-se de que a estrutura e os arquivos estão como o que foi discutido, principalmente o pom.xml configurado para Spring Boot 2.7.x e os schema.sql e application.properties em src/main/resources.
2. Configuração do pom.xml
Verifique se o seu arquivo pom.xml está configurado para o Spring Boot 2.7.x e Java 11/17 para compatibilidade com os javax.persistence dos arquivos de entidade.
<?xml version=\"1.0\" encoding=\"UTF-8\"?>
<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"
    xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd\">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.7</version> <!-- OU 2.7.17, conforme sua configuração -->
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>br.com.ebac</groupId>
    <artifactId>memelandia</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>memelandia</name>
    <description>Cadastro de memes</description>
    <properties>
        <java.version>11</java.version> <!-- OU 17 -->
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
3. Executando a Aplicação
Via IDE (Spring Tool Suite 4 - STS4) - Recomendado
1.	No STS4, clique com o botão direito no projeto memelandia no Package Explorer.
2.	Selecione Maven > Update Project... para garantir que as dependências estejam sincronizadas.
3.	Vá para a classe MemelandiaApplication.java (localizada em src/main/java/br/com/ebac/memelandia).
4.	Clique com o botão direito em MemelandiaApplication.java e selecione Run As > Spring Boot App.
5.	Observe o console do STS4. A aplicação estará pronta quando você vir a mensagem Started MemelandiaApplication in X.XXX seconds (JVM running for Y.YYY).
Via Terminal com Maven
1.	Abra um terminal e navegue até o diretório raiz do projeto memelandia (onde o pom.xml está localizado).
2.	Compile e empacote o projeto:
3.	mvn clean install
4.	Execute o arquivo JAR gerado:
5.	java -jar target/memelandia-0.0.1-SNAPSHOT.jar
A aplicação será iniciada na porta 8081 por padrão (conforme application.properties).
🌐 Como Usar a API (Usabilidade)
Com a aplicação em execução, você pode interagir com a API REST usando ferramentas como Postman, Insomnia ou curl. A base da URL para os endpoints é http://localhost:8081/memelandia.
Exemplo de Requisições
1. Criar Usuário (POST)
•	Endpoint: POST /memelandia/usuarios
•	Header: Content-Type: application/json
•	Body:
•	{
•	  \"nome\": \"Fulano de Tal\",
•	  \"email\": \"fulano.tal@example.com\",
•	  \"dataCadastro\": \"2025-10-26\"
•	}
2. Listar Usuários (GET)
•	Endpoint: GET /memelandia/usuarios
3. Criar Categoria de Meme (POST)
•	Endpoint: POST /memelandia/categorias
•	Header: Content-Type: application/json
•	Body: (Associe a um ID de usuário existente, por exemplo, o ID 1)
•	{
•	  \"nome\": \"Memes de Animais\",
•	  \"descricao\": \"Os melhores memes com bichinhos fofos!\",
•	  \"dataCadastro\": \"2025-10-26\",
•	  \"usuario\": { \"id\": 1 }
•	}
4. Listar Categorias de Memes (GET)
•	Endpoint: GET /memelandia/categorias
5. Criar Meme (POST)
•	Endpoint: POST /memelandia/memes
•	Header: Content-Type: application/json
•	Body: (Associe a um ID de categoria e um ID de usuário existentes)
•	{
•	  \"nome\": \"Meme do Doge\",
•	  \"descricao\": \"Such wow, many meme, very doge\",
•	  \"dataCadastro\": \"2025-10-26\",
•	  \"categoriaMeme\": { \"id\": 1 },
•	  \"usuario\": { \"id\": 1 }
•	}
6. Listar Memes (GET)
•	Endpoint: GET /memelandia/memes
📊 H2 Console (Banco de Dados em Memória)
Para visualizar e gerenciar o banco de dados H2 que roda em memória, você pode acessar o console através do seu navegador:
•	URL: http://localhost:8081/h2-console
•	Credenciais (conforme application.properties):
o	JDBC URL: jdbc:h2:mem:db-memelandia
o	User Name: sa
o	Password: password
No console, você pode executar queries SQL para inspecionar os dados cadastrados (SELECT * FROM USUARIO;, SELECT * FROM CATEGORIA_MEME;, SELECT * FROM MEME;).
🎯 Próximos Passos (Desafio do Módulo 15)
Esta aplicação é o ponto de partida para o grande desafio do Módulo 15:
1.	Identificação de Domínios: Analisar as entidades e funcionalidades para identificar os domínios claros (e.g., domínio de Usuários, domínio de Categorias, domínio de Memes).
2.	Criação de Microsserviços: Desmembrar o monólito em pelo menos dois (idealmente três) serviços independentes, cada um com sua responsabilidade e, se necessário, seu próprio banco de dados.
3.	Implementação de Observabilidade: Adicionar logs e métricas robustos aos novos serviços para monitoramento e diagnóstico.
4.	Considerações de Consistência: Decidir sobre a consistência dos dados (forte ou eventual) entre os novos microsserviços.
Este é um projeto que permite aplicar todos os conceitos de arquitetura e desenvolvimento aprendidos no curso!
#   � l t i m o - p r o j e t o - E s p e c i a l i s t a - e m - l i n g u a g e m - J a v a - B a c k e n d - E b a c -  
 