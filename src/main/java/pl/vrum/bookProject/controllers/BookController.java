package pl.vrum.bookProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.vrum.bookProject.model.Book;
import pl.vrum.bookProject.repositories.BookRepository;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {


    @Autowired
    BookRepository bookRepository;


    @GetMapping
    public List<Book> allBooks() {
        List<Book> list = bookRepository.findAll();
        return list;
    }

    @GetMapping("/{param1}")
    public Book  book(@PathVariable long param1) {
        return bookRepository.findById(param1);
    }

    @PostMapping
    public Book bookAdd(@RequestBody Book book) {
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




    //
//    MemoryBookService mbs;
//
//    @Autowired
//    public BookController(MemoryBookService mbs) {
//        this.mbs = mbs;
//    }
//
//    @GetMapping
//    public List<Book> allBooks() {
//        List<Book> list = mbs.getList();
//        return list;
//    }
//
//    @GetMapping("/{param1}")
//    public Book  book(@PathVariable long param1) {
//        return mbs.getBookById(param1);
//    }
//
//    @PostMapping
//    public Book bookAdd(@RequestBody Book book) {
//        mbs.addBook(book);
//        return book;
//    }
//
//    @PutMapping("/{param1}")
//    public Book update(@RequestBody Book book, @PathVariable long param1) {
//        mbs.editBookId(book, param1);
//        return book;
//    }

}