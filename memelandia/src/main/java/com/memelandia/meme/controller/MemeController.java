package com.memelandia.meme.controller;

import com.memelandia.meme.model.Meme;
import com.memelandia.meme.repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/memes")
public class MemeController {

    @Autowired
    private MemeRepository memeRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.service.url}")
    private String userServiceUrl;

    @Value("${category.service.url}")
    private String categoryServiceUrl;

    @GetMapping
    public List<Meme> getAllMemes() {
        return memeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meme> getMemeById(@PathVariable Long id) {
        Optional<Meme> meme = memeRepository.findById(id);
        return meme.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Meme> createMeme(@RequestBody Meme meme) {
        // Verificar se o usuário existe
        ResponseEntity<Object> userResponse = restTemplate.getForEntity(userServiceUrl + "/api/users/" + meme.getUserId(), Object.class);
        if (!userResponse.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.badRequest().build();
        }

        // Verificar se a categoria existe
        ResponseEntity<Object> categoryResponse = restTemplate.getForEntity(categoryServiceUrl + "/api/categories/" + meme.getCategoryId(), Object.class);
        if (!categoryResponse.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.badRequest().build();
        }

        meme.setRegistrationDate(LocalDateTime.now());
        Meme savedMeme = memeRepository.save(meme);
        return ResponseEntity.ok(savedMeme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meme> updateMeme(@PathVariable Long id, @RequestBody Meme memeDetails) {
        Optional<Meme> memeOptional = memeRepository.findById(id);

        if (memeOptional.isPresent()) {
            Meme existingMeme = memeOptional.get();
            existingMeme.setName(memeDetails.getName());
            existingMeme.setDescription(memeDetails.getDescription());
            existingMeme.setUrl(memeDetails.getUrl());
            Meme updatedMeme = memeRepository.save(existingMeme);
            return ResponseEntity.ok(updatedMeme);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeme(@PathVariable Long id) {
        if (memeRepository.existsById(id)) {
            memeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
