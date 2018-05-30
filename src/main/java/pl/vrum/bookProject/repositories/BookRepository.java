package pl.vrum.bookProject.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.vrum.bookProject.model.Book;

import java.util.Optional;


public interface BookRepository extends CrudRepository<Book, Long> {



}
