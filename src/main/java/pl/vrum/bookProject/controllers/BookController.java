package pl.vrum.bookProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.vrum.bookProject.model.Book;
import pl.vrum.bookProject.repositories.BookRepository;

import javax.validation.Valid;
import java.util.List;
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

    @GetMapping("/{param1}")
    public Book book(@PathVariable long param1) {
        return bookRepository.findById(param1);
    }

    @PostMapping
    public Book bookAdd(@ModelAttribute("book") Book book) {
        book.setId(1);
        bookRepository.save(book);
        return book;
    }

    @PutMapping("/{param1}")
    public Book update(@RequestBody Book book, @PathVariable long param1) {
        Book oldBook = bookRepository.findById(param1);

        if(oldBook!=null) {
            oldBook.setId(param1);
            oldBook.setAuthor(book.getAuthor());
            oldBook.setIsbn(book.getIsbn());
            oldBook.setPublisher(book.getPublisher());
            oldBook.setTitle(book.getTitle());
            oldBook.setType(book.getType());
            bookRepository.save(oldBook);
        }
        return oldBook;
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id)
    {
        Book book=bookRepository.findById(id);
        bookRepository.delete(book);
    }


}