// src/main/java/br/com/ebac/memelandia/services/ServicoMemelandia.java
package br.com.ebac.memelandia.services;

import br.com.ebac.memelandia.entities.CategoriaMeme;
import br.com.ebac.memelandia.entities.Meme;
import br.com.ebac.memelandia.entities.Usuario;
import br.com.ebac.memelandia.repositories.RepositorioCategoriaMeme;
import br.com.ebac.memelandia.repositories.RepositorioMeme;
import br.com.ebac.memelandia.repositories.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoMemelandia {

    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private RepositorioCategoriaMeme repositorioCategoriaMeme;
    @Autowired
    private RepositorioMeme repositorioMeme;

    public List<Usuario> listaTodosUsuarios() {
        return repositorioUsuario.findAll();
    }

    public Usuario novoUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public List<CategoriaMeme> listaTodasCategorias() {
        return repositorioCategoriaMeme.findAll();
    }

    public CategoriaMeme novaCategoriaMeme(CategoriaMeme categoriaMeme) {
        // Futuramente, você adicionará a lógica para garantir que um usuário
        // que está criando a categoria exista, se essa for a regra de negócio.
        return repositorioCategoriaMeme.save(categoriaMeme);
    }

    public List<Meme> listaTodosMemes() {
        return repositorioMeme.findAll();
    }

    public Meme novoMeme(Meme meme) {
        // IMPORTANTE: Conforme o documento "EspecialistaBackendJava m15",
        // aqui será um ponto crucial para as suas modificações futuras.
        // O documento diz: "um meme não pode ser cadastrado sem categoria
        // ou por um usuário inexistente, por exemplo. Isso implicará em
        // mudanças no seu design."
        // Neste momento, o código apenas salva o meme. Você precisará
        // implementar as validações de dependência aqui ou em camadas
        // de serviço específicas para cada microsserviço.
        return repositorioMeme.save(meme);
    }
}