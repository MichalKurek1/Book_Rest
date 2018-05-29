package pl.vrum.bookProject.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.vrum.bookProject.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findById(long param1);

}
