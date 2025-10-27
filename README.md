# Projeto de Microsserviços de Memes

Este repositório contém o código-fonte para uma aplicação de memes decomposta em uma arquitetura de microsserviços.

---

## Guia de Setup e Execução no Spring Tool Suite 4 (STS4)

Existem duas maneiras de configurar este projeto na sua IDE. A Parte 1 é para quem quer entender a estrutura construindo-a do zero. A Parte 2 é a maneira mais rápida de importar o projeto já finalizado.

### Parte 1: Como Criar a Estrutura do Projeto do Zero (O Esqueleto)

Siga estes passos para recriar a estrutura de um projeto pai com módulos.

#### **Etapa A: Criar o Projeto "Pai" (O Contêiner)**

Este projeto não terá código, ele apenas servirá para agrupar e gerenciar os microsserviços.

1.  No STS4, vá em **File -> New -> Other...**
2.  Na caixa de busca, digite `Maven Project`, selecione-o e clique em **Next**.
3.  Marque a caixa **Create a simple project (skip archetype selection)** e clique em **Next**.
4.  Preencha os campos da seguinte forma:
    *   **Group Id:** `br.com.ebac`
    *   **Artifact Id:** `meme-microsservicos`
    *   **Packaging:** selecione **pom** na lista (este é o passo mais importante).
5.  Clique em **Finish**.
6.  Após a criação, substitua o conteúdo do arquivo `pom.xml` gerado pelo conteúdo do `pom.xml` principal deste repositório. Isso irá configurar o gerenciamento de dependências e os módulos.

#### **Etapa B: Criar o Primeiro Microsserviço (Módulo `user-service`)**

Agora, vamos adicionar nosso primeiro serviço como um "Módulo Maven" dentro do projeto pai.

1.  No "Package Explorer" do STS4, clique com o botão direito no projeto pai (`meme-microsservicos`).
2.  Vá em **New -> Other...**
3.  Digite `Maven Module` na busca, selecione-o e clique em **Next**.
4.  No campo **Module Name**, digite: `user-service`.
5.  Clique em **Next**.
6.  Na tela seguinte, confirme se os campos estão corretos (`Group Id: br.com.ebac`, `Artifact Id: user-service`).
7.  Clique em **Finish**.

O STS4 criará uma estrutura de pastas para o `user-service` dentro do projeto pai. Para transformá-lo em uma aplicação Spring Boot, você precisará:
-   Criar a classe principal `UserServiceApplication.java` dentro do pacote `br.com.ebac.userservice`.
-   Criar o arquivo `application.properties` em `src/main/resources` e definir a porta (`server.port=8081`).
-   Adicionar as dependências necessárias no `pom.xml` do `user-service`.

#### **Etapa C: Repetir para os Outros Microsserviços**

Repita o processo da **Etapa B** mais duas vezes para os outros serviços, usando os seguintes nomes:

*   **Para o serviço de categorias:**
    *   **Module Name:** `category-service`
    *   **Pacote Java:** `br.com.ebac.categoryservice`
    *   **Porta no `application.properties`:** `8082`
*   **Para o serviço de memes:**
    *   **Module Name:** `meme-service`
    *   **Pacote Java:** `br.com.ebac.memeservice`
    *   **Porta no `application.properties`:** `8083`

---

### Parte 2: Como Importar o Projeto Finalizado (Caminho Rápido)

Este é o método recomendado para simplesmente abrir e executar o código que já está neste repositório.

1.  No STS4, vá em **File -> Import...**
2.  Na janela de importação, digite `Maven` na busca, selecione **Existing Maven Projects** e clique em `Next`.
3.  No campo **Root Directory**, clique em `Browse...` e selecione a pasta raiz deste projeto (a pasta que contém este `README.md`).
4.  O STS4 irá detectar o `pom.xml` pai e os três módulos (`user-service`, `category-service`, `meme-service`). Certifique-se de que todos eles estejam marcados na lista.
5.  Clique em **Finish**.

A IDE irá importar o projeto completo com toda a estrutura e dependências já configuradas.

---

### Como Executar os Serviços (Após Importar)

1.  **Limpe e atualize o projeto:**
    *   Clique com o botão direito no projeto pai (`meme-microsservicos`) -> **Maven -> Update Project...**. Marque **Force Update** e clique em **OK**.
2.  **Inicie cada serviço individualmente:**
    *   **`user-service`**: Encontre `UserServiceApplication.java`, clique com o botão direito -> **Run As -> Spring Boot App**. (Verifique a porta 8081 no console).
    *   **`category-service`**: Encontre `CategoryServiceApplication.java`, clique com o botão direito -> **Run As -> Spring Boot App**. (Verifique a porta 8082 no console).
    *   **`meme-service`**: Encontre `MemeServiceApplication.java`, clique com o botão direito -> **Run As -> Spring Boot App**. (Verifique a porta 8083 no console).
