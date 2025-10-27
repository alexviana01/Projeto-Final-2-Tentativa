package com.memelandia.categoria.repository;

import com.memelandia.categoria.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
