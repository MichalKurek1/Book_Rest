package pl.vrum.bookProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.vrum.bookProject.model.Author;
import pl.vrum.bookProject.repositories.AuthorRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/authors")
public class AuthorController {


    @Autowired
    AuthorRepository authorRepository;

    @GetMapping
    public List<Author> allAuthors() {
        List<Author> list = authorRepository.findAll();
        return list;
    }

    @GetMapping("/{param1}")
    public Author author(@PathVariable long param1) {
        return authorRepository.findById(param1);
    }

    @PostMapping
    public Author authorAdd(@RequestBody Author author) {
        authorRepository.save(author);
        return author;
    }

    @PutMapping("/{param1}")
    public Author update(@RequestBody Author author, @PathVariable long param1) {
        Author oldAuthor = authorRepository.findById(param1);
        return oldAuthor;
    }

}
