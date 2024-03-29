package com.example.AppRead.book;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid BookRequest request) {
        service.save(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/search")
    public ResponseEntity<List<Book>> getBookByName(String name, String write) {
        return ResponseEntity.ok(service.findBySearch(name, write));
    }

    @GetMapping("/{id}")
    public ResponseEntity <Optional<Book>> getBookById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findIdBook(id));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> updateBook(@RequestBody @Valid BookRequest request) {
        service.update(request);
        return ResponseEntity.ok(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
