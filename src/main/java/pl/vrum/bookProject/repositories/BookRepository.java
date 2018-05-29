package pl.vrum.bookProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vrum.bookProject.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findById(long param1);

}
