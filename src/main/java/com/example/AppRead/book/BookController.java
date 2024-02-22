package com.example.AppRead.book;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Book>> getAllExercises() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> getExerciseByName(String name, String category) {
        return ResponseEntity.ok(service.findBySearch(name, category));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> updateExercise(@RequestBody @Valid BookRequest request) {
        service.update(request);
        return ResponseEntity.ok(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExercise(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
