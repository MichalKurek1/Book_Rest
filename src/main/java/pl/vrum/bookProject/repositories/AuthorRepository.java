package pl.vrum.bookProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.vrum.bookProject.model.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findById(long param1);

}
