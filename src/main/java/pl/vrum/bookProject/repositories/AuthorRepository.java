package pl.vrum.bookProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vrum.bookProject.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findById(long param1);

}
