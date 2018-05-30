package pl.vrum.bookProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.vrum.bookProject.model.Book;
import pl.vrum.bookProject.repositories.BookRepository;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> allBooks() {
        Iterable<Book> list = bookRepository.findAll();
        return list;
    }

    @GetMapping("/{id}")
    public Optional<Book> book(@PathVariable Long id) {

        return bookRepository.findById(id);
    }

    @PostMapping
    public Book bookAdd(@ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return book;
    }

    @PutMapping(value="/{id}")
    public Book update(@RequestBody Book book, @PathVariable Long id) {
        book.setId(id);
        bookRepository.save(book);
        return book;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id)
    {
        bookRepository.deleteById(id);
    }
}