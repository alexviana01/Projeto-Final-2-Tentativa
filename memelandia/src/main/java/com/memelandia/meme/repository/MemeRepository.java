package com.memelandia.meme.repository;

import com.memelandia.meme.model.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemeRepository extends JpaRepository<Meme, Long> {
}
