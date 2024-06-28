package com.example.Bookstore.repository;

import com.example.Bookstore.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}


