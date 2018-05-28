package pl.vrum.bookProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.vrum.bookProject.MemoryBookService;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    MemoryBookService mbs;

    @Autowired
    public BookController(MemoryBookService mbs) {
        this.mbs = mbs;
    }

/*	@RequestMapping("/hello")
	public String hello() {
		return "{hello: World}";
	}*/

/*	@RequestMapping("/helloBook")
	public Book helloBook() {
		return new Book("9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
	}*/

    @GetMapping
    public List<Book> allBooks() {
        List<Book> list = mbs.getList();
        return list;
    }

    @GetMapping("/{param1}")
    public Book  book(@PathVariable long param1) {
        return mbs.getBookById(param1);
    }


    @PostMapping
    public Book bookAdd(@RequestBody Book book) {
        mbs.addBook(book);
        return book;
    }

    @PutMapping("/{param1}")
    public Book update(@RequestBody Book book, @PathVariable long param1) {
        mbs.editBookId(book, param1);
        return book;
    }

}