package com.example.AppRead.book;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private final BookRepository repository;
    private BookRequest request;

    public void save(BookRequest request) {
        var book = Book.builder()
                .id(request.getId())
                .name(request.getName())
                .cover(request.getCover())
                .writer(request.getWriter())
                .description(request.getDescription())
                .num(request.getNum())
                .pub(request.getPub())
                .year(request.getYear())
                .pdf(request.getPdf())
                .build();
        repository.save(book);
    }

    public void update(BookRequest request) {
        Optional<Book> optionalBook = repository.findById(request.getId());
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setName(request.getName());
            book.setCover(request.getCover());
            book.setNum(request.getNum());
            book.setDescription(request.getDescription());
            book.setYear(request.getYear());
            book.setWriter(request.getWriter());
            book.setPub(request.getPub());
            book.setPdf(request.getPdf());
        } else {
            throw new EntityNotFoundException();
        }

    }

    public List<Book> findAll() {
        return repository.findAll();
    }



    public Optional<Book> findIdBook(Integer id) {
        return repository.findById(id);
    }


    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Book> findBySearch(String name, String writer) {
        return repository.findByNameContainingIgnoreCaseAndWriterContainingIgnoreCase( name, writer);
    }
}
