package pl.vrum.bookProject;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MemoryBookService {
    private List<Book> list;


    public MemoryBookService() {
        long counter = 0;

        list = new ArrayList<Book>();
        list.add(new Book(1l,"9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        list.add(new Book(2l,"9788324627738", "Rusz glowa, Java.", "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3l, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Book getBookById(long id1) {

        for (Book book : list) {

            if (book.getId() == id1) {
                return book;
            }
        }
        return null;
    }

    public Book editBookById(long id1, String name, String newValue) {

        for (Book book : list) {
            if (book.getId() == id1) {
                if (name == "isbn") {
                    book.setIsbn(name);
                } else if (name == "title") {
                    book.setTitle(name);
                } else if (name == "author") {
                    book.setAuthor(name);
                } else if (name == "publisher") {
                    book.setPublisher(name);
                } else if (name == "type") {
                    book.setType(name);
                }
            }
        }
        return null;
    }

    public Book editBookId(Book book1, long id1) {

        if(getBookById(id1)!=null) {
            Book old = getBookById(id1);

            old.setId(id1);
            old.setAuthor(book1.getAuthor());
            old.setIsbn(book1.getIsbn());
            old.setPublisher(book1.getPublisher());
            old.setTitle(book1.getTitle());
            old.setType(book1.getType());

        }
        return book1;
    }

    public void deleteBookById(long id1) {

        for (Book book : list) {
            if (book.getId() == id1) {
                list.remove(book);
            }
        }
    }
    private long id = 4;

    public void addBook(Book book) {
        book.setId(id++);
        list.add(book);
    }

}