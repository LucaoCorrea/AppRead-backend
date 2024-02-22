package com.example.AppRead.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends  JpaRepository<Book, Integer> {
    List<Book> findByNameContainingIgnoreCaseAndWriterContainingIgnoreCase(String name, String writer);
}
